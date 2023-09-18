package com.salhugues.zephoraplayground.data.offline.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salhugues.zephoraplayground.data.offline.dao.ProductDao
import com.salhugues.zephoraplayground.data.offline.dao.ReviewDao
import com.salhugues.zephoraplayground.data.offline.model.DbProduct
import com.salhugues.zephoraplayground.data.offline.model.DbReview

@Database(entities = arrayOf(DbProduct::class, DbReview::class), version = 1, exportSchema = false)
abstract class ZephoraDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao
}
