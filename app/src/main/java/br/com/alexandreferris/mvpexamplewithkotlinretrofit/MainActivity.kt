package br.com.alexandreferris.mvpexamplewithkotlinretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.helper.LoadingDialog
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.presenter.BeerPresenter
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.view.BeerView

class MainActivity : AppCompatActivity(), BeerView {

    private lateinit var loadingDialog: LoadingDialog

    private lateinit var presenter: BeerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loading Dialog
        loadingDialog = LoadingDialog(this)

        presenter = BeerPresenter(this)
    }

    override fun displayBeers(beersList: ArrayList<Beer>) {

        for (beer in beersList) {
            Log.i("TAG_APP_B", "B: " + beer.name)
        }

        supportFragmentManager.beginTransaction().run {
            val frag = BeerListFragment()
            frag.setList(beersList)
            replace(R.id.fragBeerList, frag)
            commit()
        }
    }

    override fun displayNoBeers() {
        Log.i("TAG_APP_02", "NO BEERS")
    }

    override fun showLoading() {
        loadingDialog.show()
    }
    override fun hideLoading() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.loadBeers()
    }
}
