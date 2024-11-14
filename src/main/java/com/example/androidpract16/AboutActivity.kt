package com.example.androidpract16

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.about_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setTitle(R.string.about)
        findViewById<TextView>(R.id.TextAbout).setText(getString(R.string.about)+"\nВерсия программы: "+getText(R.string.app_version)+"\nВерсия программного кода: "+getString(R.string.app_version_code))

        findViewById<Button>(R.id.button_back).setOnClickListener({
            startActivity(Intent(this@AboutActivity,MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
        })
    }
}