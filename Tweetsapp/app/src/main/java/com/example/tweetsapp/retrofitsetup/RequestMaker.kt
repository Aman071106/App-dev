package com.example.tweetsapp.retrofitsetup

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//network module
//dagger uses this
//this is required for calling of retrofit object itself and avoiding boilerplate code in Mainact

//we are using retrofit obj to make the api request


@Module
@InstallIn(SingletonComponent::class)
class RequestMaker {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideTweetsAPI(retrofit: Retrofit):RequestMakerMethods{
        return retrofit.create(RequestMakerMethods::class.java)
    }
}