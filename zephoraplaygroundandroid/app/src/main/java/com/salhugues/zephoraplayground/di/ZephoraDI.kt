package com.salhugues.zephoraplayground.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.salhugues.zephoraplayground.data.local.datasource.LocalProductDatasource
import com.salhugues.zephoraplayground.data.local.datasource.LocalReviewDatasource
import com.salhugues.zephoraplayground.data.local.room.ZephoraDatabase
import com.salhugues.zephoraplayground.data.remote.api.ApiClient
import com.salhugues.zephoraplayground.data.remote.datasource.RemoteProductDatasource
import com.salhugues.zephoraplayground.data.remote.datasource.RemoteReviewDatasource
import com.salhugues.zephoraplayground.data.repository.ProductRepository
import com.salhugues.zephoraplayground.data.repository.ReviewRepository
import com.salhugues.zephoraplayground.domain.usecase.GetProductFormatterUseCase
import com.salhugues.zephoraplayground.domain.usecase.GetProductsUseCase
import com.salhugues.zephoraplayground.domain.usecase.SyncDataUseCase
import com.salhugues.zephoraplayground.misc.Constants.BASE_URL
import com.salhugues.zephoraplayground.misc.Constants.DATABASE_NAME
import com.salhugues.zephoraplayground.misc.Constants.DISPATCHER_IO
import com.salhugues.zephoraplayground.presentation.splash.SplashScreenActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

object ZephoraDI {
    fun loadModules() = listOf(
        buildLocalModule(),
        buildRemoteModule(),
        buildAppModule(),
        buildActivityModule()
    )

    private fun buildActivityModule() = module {
        scope<SplashScreenActivity> {
            scoped {
                SyncDataUseCase(get(), get(), get())
            }
        }
    }

    private fun buildAppModule() = module {
        single(qualifier = named(DISPATCHER_IO)) { Dispatchers.IO }

        // Repositories
        single { ProductRepository(get(), get()) }
        single { ReviewRepository(get(), get()) }

        // Use cases
        single { SyncDataUseCase(get(), get(), get()) }
        singleOf(::GetProductFormatterUseCase)
        singleOf(::GetProductsUseCase)
    }

    private fun buildRemoteModule() = module {
        // retrofit
        single<ApiClient> {
            val json = Json {
                ignoreUnknownKeys = true
            }

            val converter = json.asConverterFactory("application/json".toMediaType())

            val client = OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()

            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(converter)
                .client(client)
                .build()
                .create(ApiClient::class.java)
        }

        // Remote datasource
        single { RemoteProductDatasource(get()) }
        single { RemoteReviewDatasource(get()) }
    }

    private fun buildLocalModule() = module {
        // room database
        single {
            Room.databaseBuilder(
                androidApplication(),
                ZephoraDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        // Dao
        single { get<ZephoraDatabase>().productDao() }
        single { get<ZephoraDatabase>().reviewDao() }

        // Local datasource
        single { LocalProductDatasource(get()) }
        single { LocalReviewDatasource(get()) }
    }
}
