package com.mmh.knigolyub.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.R
import com.rbddevs.splashy.Splashy

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSplashScreen()
        finish()
    }

    private fun setSplashScreen() {
        Splashy(this)
            .setLogo(R.drawable.book)
            .setSubTitle("«Те, кто читает книги, всегда будут управлять теми, кто смотрит телевизор». Билл Гейтс")
            .setSubTitleColor(R.color.white)
            .setTitle(getString(R.string.knigolyub))
            .setSubTitleSize(14f)
            .setTitleColor("#FFFFFF")
            .showProgress(true)
            .setProgressColor(R.color.white)
            .setBackgroundResource(R.drawable.background_start)
            .setFullScreen(true)
            .setAnimation(Splashy.Animation.SLIDE_IN_TOP_BOTTOM, 1000)
            .setDuration(2000)
            .show()

        Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            }

        })
    }
}