package net.ticket.loca.locabus.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*
import net.ticket.loca.locabus.R
import android.view.animation.ScaleAnimation


class SplashScreen : AppCompatActivity() {

    private val Bottomanimation: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //animation for screen and views
        //zoom Animation
        val scal = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat()
        )
        scal.duration = 1000
        scal.fillAfter = true
        logo_image.animation = scal
        app_name.animation = AnimationUtils.loadAnimation(this, R.anim.from_bottom)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, IntroductionScreen::class.java))
            overridePendingTransition(R.anim.enter, R.anim.exit)
            finish()
        }, 3000)

    }
}
