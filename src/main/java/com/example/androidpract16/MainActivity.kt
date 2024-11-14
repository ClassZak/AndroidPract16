package com.example.androidpract16

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        menu?.getItem(R.id.change_theme)?.setTitle(if(isDarkMode(this))
            R.string.changeToLight;
        else
            R.string.changeToDark)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        when(item.itemId){
            R.id.about_menu_item -> title = "О программе"
            R.id.change_theme -> {
                changeTheme(this)
                if(isDarkMode(this))
                    item.setTitle(R.string.changeToLight)
                else
                    item.setTitle(R.string.changeToDark)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
        catch (e:Exception){
            val message:Toast=Toast.makeText(this,"Ошибка\n"+e.message,Toast.LENGTH_LONG)
            message.show()
        }
    }

    fun isDarkMode(context: Context): Boolean {
        return context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
    fun switchChangeTheme(view: View){
        changeTheme(this)
    }
    fun changeTheme(context:Context){
        if(isDarkMode(context))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}