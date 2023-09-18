package com.salhugues.zephoraplayground.data.offline.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salhugues.zephoraplayground.data.offline.model.DbProduct

private const val GET_ALL = "SELECT * FROM Product ORDER BY productId ASC"

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: DbProduct)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<DbProduct>)

    @Query(GET_ALL)
    fun getAll(): List<DbProduct>
}
