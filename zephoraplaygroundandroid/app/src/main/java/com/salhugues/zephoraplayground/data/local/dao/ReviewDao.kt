package com.salhugues.zephoraplayground.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salhugues.zephoraplayground.data.local.model.DbReview

private const val GET_ALL = "SELECT * FROM Review ORDER BY rating DESC"
private const val GET_ALL_REVIEWS_BY_PRODUCT_ID =
    "SELECT * FROM Review WHERE relProductId LIKE (:id) ORDER BY rating DESC"

@Dao
interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(review: DbReview)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reviews: List<DbReview>)

    @Query(GET_ALL_REVIEWS_BY_PRODUCT_ID)
    fun getReviewsByProductId(id: Long): List<DbReview>

    @Query(GET_ALL)
    fun getAll(): List<DbReview>
}
