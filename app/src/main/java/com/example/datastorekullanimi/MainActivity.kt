package com.example.datastorekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ap= AppPref(this@MainActivity)


        CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("Ahmet")
            val gelenAd= ap.okuAd()
            println(gelenAd)

            //ap.silAd()



            ap.yasEkle(3)
            println(ap.yasOku())
        }


    }
}