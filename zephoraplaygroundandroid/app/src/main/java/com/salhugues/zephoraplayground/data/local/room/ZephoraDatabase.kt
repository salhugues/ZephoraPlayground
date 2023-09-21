package com.salhugues.zephoraplayground.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salhugues.zephoraplayground.data.local.dao.ProductDao
import com.salhugues.zephoraplayground.data.local.dao.ReviewDao
import com.salhugues.zephoraplayground.data.local.model.DbProduct
import com.salhugues.zephoraplayground.data.local.model.DbReview

@Database(entities = [DbProduct::class, DbReview::class], version = 1, exportSchema = false)
abstract class ZephoraDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao
}
