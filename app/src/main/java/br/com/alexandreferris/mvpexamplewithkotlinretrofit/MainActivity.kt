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

    override fun displayBeers(carsList: List<Beer>) {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
        Log.i("TAG_APP_01", "CAIU 1")
    }

    override fun displayNoBeers() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
        Log.i("TAG_APP_02", "CAIU 2")
    }
}
