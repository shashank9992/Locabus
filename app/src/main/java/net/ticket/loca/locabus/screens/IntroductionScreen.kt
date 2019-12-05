package net.ticket.loca.locabus.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_introduction_screen.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.IntroPagerAdapter
import net.ticket.loca.locabus.fragments.intro_fragments.IntroFirstFragment
import net.ticket.loca.locabus.fragments.intro_fragments.IntroSecondFragment
import net.ticket.loca.locabus.fragments.intro_fragments.IntroThirdFragment
import java.util.*
import android.os.Handler
import android.os.Looper


class IntroductionScreen : AppCompatActivity() {

    companion object {
        private const val MIN_SCALE = 0.65f
        private const val MIN_ALPHA = 0.3f
    }

    //...
    var currentPage = 0
    val DELAY_MS: Long = 300//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 5000 // time in milliseconds between successive task executions.


    private lateinit var pagerAdapterView: IntroPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction_screen)

        pagerAdapterView = IntroPagerAdapter(supportFragmentManager)
        addPagerFragments()

        myViewPager.adapter = pagerAdapterView
        myViewPager.setPageTransformer(true, this::zoomOutTransformation)
        myViewPager.offscreenPageLimit = 0
//        myViewPager.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
        worm_dots_indicator.setViewPager(myViewPager)

        /*After setting the adapter use the timer */
        val Update = Runnable {
            if (currentPage != pagerAdapterView.count)  {
                myViewPager.setCurrentItem(currentPage++, true)
            }else{

            }
        }

        val timer = Timer() // This will create a new Thread
        timer.schedule(object : TimerTask() { // task to be scheduled
            override fun run() { Handler(Looper.getMainLooper()).post(Update)
            }
        }, DELAY_MS, PERIOD_MS)

        signup_as_guest.setOnClickListener {
            startActivity(Intent(this@IntroductionScreen, DashBoard::class.java))
            overridePendingTransition(R.anim.enter, R.anim.exit)
            finish()
        }

    }
    private fun addPagerFragments() {
        pagerAdapterView.addFragments(IntroFirstFragment())
        pagerAdapterView.addFragments(IntroSecondFragment())
        pagerAdapterView.addFragments(IntroThirdFragment())
    }

    private fun zoomOutTransformation(page: View, position: Float) {
        when {
            position < -1 ->
                page.alpha = 0f
            position <= 1 -> {
                page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            }
            else -> page.alpha = 0f
        }
    }
}

