package br.com.alexandreferris.mvpexamplewithkotlinretrofit.presenter

import android.util.Log
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.data.Beerrepository
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.view.BeerView
import retrofit2.Call
import retrofit2.Response

/**
 * Created by alexandre on 14/08/18.
 */
class BeerPresenter {

    private val view: BeerView
    private val api: Beerrepository = Beerrepository.create()

    constructor(view: BeerView) {
        this.view = view
    }

    fun loadBeers() {

        api.getBeers().enqueue(object : retrofit2.Callback<List<Beer>> {
            override fun onFailure(call: Call<List<Beer>>?, t: Throwable?) {
                view.displayNoBeers()
            }

            override fun onResponse(call: Call<List<Beer>>?, response: Response<List<Beer>>?) {
                response?.body()?.let {
                    val cars: List<Beer> = it
                    view.displayBeers(cars)
                }
            }

        })
    }
}