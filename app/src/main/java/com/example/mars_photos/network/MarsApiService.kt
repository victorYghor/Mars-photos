package com.example.mars_photos.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
// import retrofit2.converter.scalars.ScalarsConverterFactory
// todo what scalarconverterfactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>

}


object MarsApi {
    val retrofitService: MarsApiService by lazy {
        Log.i("debug", "the lazy block is reach")
        retrofit.create(MarsApiService::class.java)
    }
}