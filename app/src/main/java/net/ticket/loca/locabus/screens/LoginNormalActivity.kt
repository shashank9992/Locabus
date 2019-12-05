package net.ticket.loca.locabus.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_normal.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.helpers.SetKeybordWithView


class LoginNormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_normal)
        SetKeybordWithView.setupUI(this@LoginNormalActivity, container_login)
        signup_google.setOnClickListener {
            val snackbar = Snackbar
                .make(container_login, "Function Yet to Implement.", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        signup_facebook.setOnClickListener {
            val snackbar = Snackbar
                .make(container_login, "Function Yet to Implement..", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        send.setOnClickListener {
            validateAndSendTo(ed_email_phone.text.toString())
        }

        as_guest.setOnClickListener {
            startActivity(Intent(this@LoginNormalActivity, DashBoard::class.java))
            overridePendingTransition(R.anim.enter, R.anim.exit)
            finish()
        }
    }

    private fun validateAndSendTo(toString: String) {
        if (toString.isNotEmpty()) {
            var intent: Intent? = null
            if (isValidEmailAddress(toString)) {
                progress_layout.visibility = View.VISIBLE
                Handler().postDelayed({
                    val intent1 = Intent(this@LoginNormalActivity, LoginWithEmailActivity::class.java)
                    intent1.putExtra("email", toString)
                    startActivity(intent1)
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                }, 1500)
            } else if (isValidMobileNumber(toString)) {
                intent = Intent(this@LoginNormalActivity, LoginWithMobileActivity::class.java)
                intent.putExtra("mobile", toString)
                startActivity(intent)
                overridePendingTransition(R.anim.enter, R.anim.exit)

            } else {
                val snackbar = Snackbar
                    .make(container_login, "Please enter valid email or mobile number.", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        } else {
            val snackbar = Snackbar
                .make(container_login, "Please enter valid email or mobile number.", Snackbar.LENGTH_LONG)
            snackbar.show()
        }

    }

    private fun isValidMobileNumber(phone: String): Boolean {
        return android.util.Patterns.PHONE.matcher(phone).matches() && phone.length == 10
    }

    private fun isValidEmailAddress(str: String): Boolean {
        return (!TextUtils.isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches());
    }
}
