package com.aleexalvz.sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aleexalvz.login_manager.builder.LoginManager

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textName = findViewById<TextView>(R.id.text_name)
        val loggedUser = LoginManager.getLoggedUser()

        textName.text = loggedUser?.name
    }
}