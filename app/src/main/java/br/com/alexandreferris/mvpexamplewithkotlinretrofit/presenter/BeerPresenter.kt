package br.com.alexandreferris.mvpexamplewithkotlinretrofit.presenter

import br.com.alexandreferris.mvpexamplewithkotlinretrofit.data.Beerrepository
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.view.BeerView
import retrofit2.Call
import retrofit2.Callback
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
        view.showLoading()
        api.getBeers().enqueue(object : Callback<ArrayList<Beer>> {
            override fun onFailure(call: Call<ArrayList<Beer>>?, t: Throwable?) {
                view.hideLoading()
                view.displayNoBeers()
            }

            override fun onResponse(call: Call<ArrayList<Beer>>?, response: Response<ArrayList<Beer>>?) {
                view.hideLoading()
                response?.body()?.let {
                    val beers: ArrayList<Beer> = it
                    view.displayBeers(beers)
                }
            }
        })
    }
}