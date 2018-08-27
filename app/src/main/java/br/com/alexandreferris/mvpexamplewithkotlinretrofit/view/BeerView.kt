package br.com.alexandreferris.mvpexamplewithkotlinretrofit.view

import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer

/**
 * Created by alexandre on 14/08/18.
 */
interface BeerView {

    fun displayBeers(beerList: ArrayList<Beer>)

    fun displayNoBeers()

    fun showLoading()

    fun hideLoading()
}