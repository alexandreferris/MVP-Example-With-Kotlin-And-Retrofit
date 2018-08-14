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

        presenter = BeerPresenter(this)

        loadingDialog = LoadingDialog(this)
        loadingDialog.show()
        presenter.loadBeers()
    }

    override fun displayBeers(beersList: List<Beer>) {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }

        for (beer in beersList) {
            Log.i("TAG_APP_B", "B: " + beer.name)
        }

        Log.i("TAG_APP_01", "DISPLAY BEERS")
    }

    override fun displayNoBeers() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
        Log.i("TAG_APP_02", "NO BEERS")
    }
}
