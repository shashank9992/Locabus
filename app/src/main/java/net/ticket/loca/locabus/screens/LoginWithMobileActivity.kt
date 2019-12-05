package net.ticket.loca.locabus.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_with_mobile.*
import net.ticket.loca.locabus.R

class LoginWithMobileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_mobile)
        val mobile = intent.getStringExtra("mobile")
        mobilenumber.setText(mobile)
        edit_number.setOnClickListener { onBackPressed() }
        login_with_password.setOnClickListener {    val snackbar = Snackbar
            .make(container, "Function Yet to Implement..", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        verify.setOnClickListener {    val snackbar = Snackbar
            .make(container, "Function Yet to Implement..", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        resend.setOnClickListener {    val snackbar = Snackbar
            .make(container, "Function Yet to Implement..", Snackbar.LENGTH_LONG)
            snackbar.show() }
    }
}
