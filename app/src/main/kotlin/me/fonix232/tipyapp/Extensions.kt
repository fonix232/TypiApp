package me.fonix232.tipyapp

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.util.Synk
import org.koin.standalone.KoinComponent
import retrofit2.Retrofit
import timber.log.Timber

inline fun <reified T : Any> KoinComponent.retrofit() = lazy {
    getKoin().get<Retrofit>().create(T::class.java)
}

inline fun <reified T : Any> UpsertDao<T>.upsertAll(data: Iterable<T>) = data.forEach { upsert(it) }

fun <T> PublishSubject<T>.toLiveData(disposable: CompositeDisposable): LiveData<T> {
    val data = MutableLiveData<T>()
    disposable.add(this.subscribe { data.postValue(it) })
    return data
}

fun <T> PublishSubject<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.LATEST))

fun <T> PublishSubject<Outcome<T>>.failed(e: Throwable) {
    e.printStackTrace()
    loading(false)
    onNext(Outcome.failure(e))
}

fun <T> PublishSubject<Outcome<T>>.success(t: T) {
    loading(false)
    onNext(Outcome.success(t))
}

fun <T> PublishSubject<Outcome<T>>.loading(isLoading: Boolean) {
    this.onNext(Outcome.loading(isLoading))
}

fun <T> Single<T>.updateSynkStatus(key: String, synk: Synk): Single<T> =
    this.doOnSuccess { synk.syncSuccess(key = key) }
        .doOnError { synk.syncFailure(key = key) }


fun Disposable.addTo(compositeDisposable: CompositeDisposable) = compositeDisposable.add(this)

fun Completable.performOnBackOutOnMain(): Completable =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.performOnBackOutOnMain(): Flowable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.performOnBackOutOnMain(): Single<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.performOnBackOutOnMain(): Observable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.performOnBack(): Flowable<T> = this.subscribeOn(Schedulers.io())

fun Completable.performOnBack(): Completable = this.subscribeOn(Schedulers.io())

fun <T> Observable<T>.performOnBack(): Observable<T> = this.subscribeOn(Schedulers.io())