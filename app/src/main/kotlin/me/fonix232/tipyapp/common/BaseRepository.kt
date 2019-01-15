package me.fonix232.tipyapp.common

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import me.fonix232.tipyapp.*
import me.fonix232.tipyapp.api.IClient
import me.fonix232.tipyapp.db.TipyDb
import me.fonix232.tipyapp.model.Comment
import me.fonix232.tipyapp.util.Synk
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Response

abstract class BaseRepository<T> : KoinComponent {
    //region Dependency Injection
    protected val client: IClient by inject()
    protected val db: TipyDb by inject()
    protected val disposable: CompositeDisposable by inject()
    protected val synk: Synk by inject()
    //endregion

    //region Abstract stuff
    abstract val dao: UpsertDao<T>

    abstract fun fetchAllFromLocal(): Flowable<List<T>>
    abstract fun fetchSingleFromLocal(id: Int): Flowable<T>
    abstract fun fetchAllFromRemote(): Single<Response<List<T>>>
    abstract fun fetchSingleFromRemote(id: Int): Single<Response<T>>
//    abstract fun saveAll(response: Response<List<T>>)
//    abstract fun saveSingle(response: Response<T>)

    abstract fun getSynkAllKey(): String
    abstract fun getSynkSingleKey(id: Int): String

    val singleResult: PublishSubject<Outcome<T>> = PublishSubject.create()
    val listResult: PublishSubject<Outcome<List<T>>> = PublishSubject.create()
    //endregion

    fun fetchAll() {
        listResult.loading(true)
        fetchAllFromLocal()
            .performOnBackOutOnMain()
            .doAfterNext {
                if (synk.shouldSync(getSynkAllKey())) refreshAll()
            }
            .subscribe({ listResult.success(it) }, { listResult.failed(it) })
            .addTo(disposable)
    }

    fun refreshAll() {
        listResult.loading(true)
        fetchAllFromRemote()
            .performOnBackOutOnMain()
            .updateSynkStatus(getSynkAllKey(), synk)
            .subscribe({ saveAll(it) }, { listResult.failed(it) })
            .addTo(disposable)
    }

    fun fetchSingle(id: Int) {
        singleResult.loading(true)
        fetchSingleFromLocal(id)
            .performOnBackOutOnMain()
            .doAfterNext {
                if (synk.shouldSync(getSynkSingleKey(id))) refreshSingle(id)
            }
            .subscribe({ singleResult.success(it) }, { singleResult.failed(it) })
            .addTo(disposable)
    }

    fun refreshSingle(id: Int) {
        singleResult.loading(false)
        fetchSingleFromRemote(id)
            .performOnBackOutOnMain()
            .updateSynkStatus(getSynkSingleKey(id), synk)
            .subscribe({saveSingle(it)}, {singleResult.failed(it)})
            .addTo(disposable)
    }

    fun saveAll(response: Response<List<T>>) {
        Completable.fromAction {
            response.body()?.forEach { dao.upsert(it) }
        }.performOnBack().subscribe()
    }

    fun saveSingle(response: Response<T>) {
        Completable.fromAction {
            response.body()?.apply { dao.upsert(this) }
        }.performOnBack().subscribe()
    }

    fun clean() {
        dao.deleteAll()
    }
}