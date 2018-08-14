package br.com.alexandreferris.mvpexamplewithkotlinretrofit.helper

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import com.airbnb.lottie.LottieAnimationView

import br.com.alexandreferris.mvpexamplewithkotlinretrofit.R

/**
 * Created by alexandre on 14/08/18.
 */
class LoadingDialog : Dialog {

    private lateinit var lottieAnimationView: LottieAnimationView

    constructor(context: Context?) : super(context, R.style.TransparentProgressDialog)

    fun prepare() {
        // Garther Window Attributes
        var windowAttributes = window.attributes

        // Set gravity of Window Attributes to CENTER_HORIZONTAL
        windowAttributes.gravity = Gravity.CENTER_HORIZONTAL

        // Update de changes
        window.attributes = windowAttributes

        // Properties from Dialog
        setTitle(null)
        setCancelable(false)
        setOnCancelListener(null)

        // Define Layout
        val layout = LinearLayout(context)

        // Set layout orientation and width / height
        layout.orientation = LinearLayout.VERTICAL
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        // Set Lottie Animation configurations and animation from json file
        lottieAnimationView = LottieAnimationView(context)
        lottieAnimationView.scaleType = ImageView.ScaleType.CENTER_CROP
        lottieAnimationView.setAnimation("animations/anim_loading.json")
        lottieAnimationView.loop(true)

        layout.addView(lottieAnimationView)
        addContentView(layout, params)
    }

    override fun show() {
        this.prepare()
        super.show()
        lottieAnimationView.playAnimation()
    }
}