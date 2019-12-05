package net.ticket.loca.locabus.screens

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.fragments.bottom_fragments.HomeFragment
import net.ticket.loca.locabus.fragments.bottom_fragments.NotificationFragment
import net.ticket.loca.locabus.fragments.bottom_fragments.PassHistoryFragment
import net.ticket.loca.locabus.fragments.bottom_fragments.ProfileFragment
import net.ticket.loca.locabus.helpers.SessionManager
import java.util.*

class DashBoard : AppCompatActivity() {

    private val fragment1: Fragment = HomeFragment()
    private val fragment2: Fragment = PassHistoryFragment()
    private val fragment3: Fragment = ProfileFragment()
    private val fragment4: Fragment = NotificationFragment()

    private val fm = supportFragmentManager
    private var active = fragment1
    private var myLocale: Locale? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_paas_history -> {
                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                fm.beginTransaction().hide(active).show(fragment3).commit()
                active = fragment3
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fm.beginTransaction().hide(active).show(fragment4).commit()
                active = fragment4
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        val sessionManager = SessionManager(this)
        setLocale(sessionManager.appLocale)
        setContentView(R.layout.activity_dash_board)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


       // sessionManager.checkLogin()

        fm.beginTransaction().add(R.id.main_container, fragment4, "4").hide(fragment4).commit()
        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit()

    }


    fun setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            val slide = android.transition.Slide()
            slide.slideEdge = Gravity.LEFT
            slide.duration = 900
            slide.interpolator = DecelerateInterpolator()
            window.exitTransition = slide
            window.enterTransition = slide
        }
    }

    fun setLocale(lang: String) {

        myLocale = Locale(lang)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)

    }
}
