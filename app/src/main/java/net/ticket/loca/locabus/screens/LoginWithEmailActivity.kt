package net.ticket.loca.locabus.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_with_email.*
import net.ticket.loca.locabus.R

class LoginWithEmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_email)
        val email = intent.getStringExtra("email")
        user_email.setText(email)

    }
}
