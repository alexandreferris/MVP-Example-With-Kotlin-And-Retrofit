package br.com.alexandreferris.mvpexamplewithkotlinretrofit.data

import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by alexandre on 14/08/18.
 */
interface Beerrepository {

    @GET("beers")
    fun getBeers(): Call<List<Beer>>


    companion object Factory {
        fun create(): Beerrepository {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(Beerrepository::class.java)
        }
    }

}