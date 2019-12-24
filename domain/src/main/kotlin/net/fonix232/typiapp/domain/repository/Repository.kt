package net.fonix232.typiapp.domain.repository

import androidx.lifecycle.LiveData
import net.fonix232.typiapp.domain.client.IClient
import net.fonix232.typiapp.domain.db.IDatabase
import net.fonix232.typiapp.domain.model.BaseModel

interface Repository<T: BaseModel> {
    val client: IClient<T>
    val database: IDatabase<T>

    val items: LiveData<List<T>>

    suspend fun sync()
    fun get(id: Int): T?
    fun getLive(id: Int): LiveData<T?>
}
