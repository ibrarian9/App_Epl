package com.app.submissionakhir

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.submissionakhir.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var bind: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.ivBack.setOnClickListener {
            startActivity(Intent(this@AboutActivity, MainActivity::class.java))
        }
    }
}