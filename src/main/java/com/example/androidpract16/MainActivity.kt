package com.example.androidpract16

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var theme:Int?=R.style.AppThemePrimary
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        installNewTheme()

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(theme!=null)
            findViewById<Switch>(R.id.switch1).isChecked=theme!=R.style.AppThemeSecondary


        findViewById<Switch>(R.id.switch1).setOnCheckedChangeListener{_, isChecked ->
            val intent: Intent =Intent(this@MainActivity,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)


            if (theme == null) {
                this.theme=R.style.AppThemePrimary
            }
            if(theme==R.style.AppThemePrimary)
                this.theme=R.style.AppThemeSecondary
            else
                this.theme=R.style.AppThemePrimary

            intent.putExtra("theme",theme)

            startActivity(intent)
        }
    }
    fun installNewTheme(){
        val arguments:Bundle?=intent.extras
        if(arguments!=null){
            theme=arguments.get("theme")as Int

            if(theme!=null)
                setTheme(theme!!)
        }
    }
}