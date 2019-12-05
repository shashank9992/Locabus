package net.ticket.loca.locabus.fragments.intro_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.intro_first_fragment.view.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.screens.LoginNormalActivity


class IntroFirstFragment : Fragment() {

    var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = layoutInflater.inflate(R.layout.intro_first_fragment, container, false)

        rootView?.let {
            it.skip_button.setOnClickListener {
                startActivity(Intent(context, LoginNormalActivity::class.java))
                activity?.overridePendingTransition(R.anim.enter, R.anim.exit)
                activity?.finish()
            }
        }
        return rootView
    }

    override fun onResume() {
        super.onResume()
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

        rootView?.let {
            it.inter_bus_tv.animation = AnimationUtils.loadAnimation(context, R.anim.from_top)
            it.bus_img.animation = scal
            it.desc_tv.animation = AnimationUtils.loadAnimation(context, R.anim.from_top)
            it.skip_button.animation = AnimationUtils.loadAnimation(context, R.anim.from_bottom)
        }

    }


}