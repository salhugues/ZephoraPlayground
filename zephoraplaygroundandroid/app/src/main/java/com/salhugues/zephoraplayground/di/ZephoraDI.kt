package com.salhugues.zephoraplayground.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.salhugues.zephoraplayground.data.offline.room.ZephoraDatabase
import com.salhugues.zephoraplayground.data.online.api.ApiClient
import com.salhugues.zephoraplayground.data.online.datasource.OnlineProductDatasource
import com.salhugues.zephoraplayground.data.online.datasource.OnlineReviewDatasource
import com.salhugues.zephoraplayground.misc.Constants.BASE_URL
import com.salhugues.zephoraplayground.misc.Constants.DATABASE_NAME
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

object ZephoraDI {
    fun loadModules() = listOf(
        buildAppModule(),
        buildOnlineModule(),
        buildOfflineModule()
    )

    private fun buildAppModule() = module {
        // repositories & uses cases
    }

    private fun buildOnlineModule() = module {
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

        single {
            OnlineProductDatasource()
        }

        single {
            OnlineReviewDatasource()
        }
    }

    private fun buildOfflineModule() = module {
        // room database
        single<RoomDatabase> {
            Room.databaseBuilder(
                androidApplication(),
                ZephoraDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        single {

        }

        single {

        }
    }
}
