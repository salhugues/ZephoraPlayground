package com.salhugues.zephoraplayground.domain.usecase

import com.salhugues.zephoraplayground.data.repository.ProductRepository
import com.salhugues.zephoraplayground.data.repository.ReviewRepository
import com.salhugues.zephoraplayground.misc.ResultState
import com.salhugues.zephoraplayground.misc.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SyncDataUseCase(
    private val productRepository: ProductRepository,
    private val reviewRepository: ReviewRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): ResultState<Boolean> {
        return withContext(dispatcher) {

            val localProductResult = async { productRepository.getLocalProducts() }.await()
            val localReviewResult = async { reviewRepository.getLocalReviews() }.await()
            val isAlreadySynced =
                localProductResult.isNotEmpty() && localReviewResult.isNotEmpty()

            if (isAlreadySynced) {
                ResultState.success(true)
            } else {
                val productResult = async { productRepository.getProducts() }.await()

                if (productResult.status == Status.SUCCESS && !productResult.data.isNullOrEmpty()) {
                    productRepository.saveAllProducts(productResult.data) // We save product
                    val reviewResult =
                        async { reviewRepository.getReviews() }.await() // We execute the second request

                    if (reviewResult.status == Status.SUCCESS && !reviewResult.data.isNullOrEmpty()) {
                        // save reviews in local database
                        reviewRepository.saveAllReviews(reviewResult.data)
                        ResultState.success(true)
                    } else {
                        ResultState.error("Error with reviews", false)
                    }
                } else {
                    ResultState.error("Error with products", false)
                }
            }
        }
    }
}