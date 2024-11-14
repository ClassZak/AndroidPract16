package com.example.androidpract16

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)


            //installNewTheme()

            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            findViewById<Switch>(R.id.switch1).setOnCheckedChangeListener{_, isChecked ->
                if(isChecked)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                else
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            /*if(theme!=null)
                findViewById<Switch>(R.id.switch1).isChecked=theme!=R.style.AppThemeSecondary_Light


            findViewById<Switch>(R.id.switch1).setOnCheckedChangeListener{_, isChecked ->
                val intent: Intent =Intent(this@MainActivity,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)


                if (theme == null) {
                    this.theme=R.style.AppThemePrimary_Light
                }
                if(theme==R.style.AppThemePrimary_Light)
                    this.theme=R.style.AppThemeSecondary_Light
                else
                    this.theme=R.style.AppThemePrimary_Light

                intent.putExtra("theme",theme)

                startActivity(intent)
            }*/
        }
        catch (e:Exception){
            val message:Toast=Toast.makeText(this,"Ошибка\n"+e.message,Toast.LENGTH_LONG)
            message.show()
        }
    }
    /*fun installNewTheme(){
        val arguments:Bundle?=intent.extras
        if(arguments!=null){
            theme=arguments.get("theme")as Int

            if(theme!=null)
                setTheme(theme!!)
        }
    }*/
}