package com.example.booksearch.app.module

import com.example.booksearch.data.service.GoogleBooksApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single(named("BooksOkhttpClient")) {
        val logsInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logsInterceptor)
//            .addInterceptor(
//                ChuckInterceptor(androidContext())
//            )
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(get(named("BooksOkhttpClient")))
            .build()
            .create(GoogleBooksApi::class.java)
    }

    single<Gson> {
        GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }
}
