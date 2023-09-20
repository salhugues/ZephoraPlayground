package com.salhugues.zephoraplayground.domain.usecase

import com.salhugues.zephoraplayground.data.repository.ProductRepository
import com.salhugues.zephoraplayground.data.repository.ReviewRepository
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.ResultState
import com.salhugues.zephoraplayground.misc.Status
import com.salhugues.zephoraplayground.presentation.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val reviewRepository: ReviewRepository,
    private val dispatcher: CoroutineDispatcher,
    private val uiProductFormatterUseCase: GetProductFormatterUseCase
) {

    suspend operator fun invoke(): ResultState<List<Product>> {
        withContext(dispatcher) {
            val productResult = getAllProducts().await()

            if (productResult.status == Status.SUCCESS) {
                val reviewResult = reviewRepository.getLocalReviews()
                productResult.data?.let { productRepository.saveAllProducts(productResult.data) }
                ResultState.success(reviewResult)
            } else {
                ResultState.error(productResult.message, null)
            }
        }

        return ResultState.success(uiProductFormatterUseCase(listOf(), listOf()))
    }

    private suspend fun getAllProducts(): Deferred<ResultState<List<DmProduct>>> =
        withContext(dispatcher) {
            async { productRepository.getProducts() }
        }

    /*private suspend fun getAllReviews(): Deferred<ResultState<List<DmReview>>> {
        return withContext(dispatcher) {
            async {

                if (productResult.status == Status.SUCCESS) {
                    val reviewResult = reviewRepository.getLocalReviews()
                    productResult.data?.let { productRepository.saveAllProducts(productResult.data) }
                    ResultState.success(reviewResult)
                } else {
                    ResultState.error(productResult.message, null)
                }
            }
        }
    }*/
}