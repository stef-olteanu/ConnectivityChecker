package com.example.connectivitychecker

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(!isMobileDataEnabled()) {
            val fragmentManger = supportFragmentManager;
            val fragmentTransaction = fragmentManger.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container,DataNotEnabledFragment()).addToBackStack("data_not_enabled")
            fragmentTransaction.commit()
        }
    }

    private fun isMobileDataEnabled() : Boolean {
        var mobileDataEnabled = false
        val connectivityManager: ConnectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            val mClass = Class.forName(connectivityManager.javaClass.name)
            val method = mClass.getDeclaredMethod("getMobileDataEnabled")
            method.isAccessible = true
            mobileDataEnabled = method.invoke(connectivityManager) as Boolean
        } catch (e: Exception) {
            Log.e("CONNECTIVITY", e.message.toString())
        }
        return mobileDataEnabled
    }
}