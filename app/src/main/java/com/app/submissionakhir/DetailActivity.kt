package com.app.submissionakhir

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.submissionakhir.databinding.ActivityDetailBinding
import com.app.submissionakhir.model.Club

class DetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val dataClub = if (Build.VERSION.SDK_INT  >= 33) {
            intent.getParcelableExtra("key_club", Club::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_hero")
        }

        bind.actionShare.setOnClickListener{
            Toast.makeText(this@DetailActivity, "Share ${dataClub?.name}", Toast.LENGTH_SHORT).show()
        }

        bind.back.setOnClickListener {
            startActivity(Intent(this@DetailActivity, MainActivity::class.java))
        }

        dataClub?.let {
            bind.tvJudul.text = it.name
            bind.tvDesc.text = it.desc
            bind.tvStadium.text = it.stadium
            bind.tvEpl.text = it.epl
            bind.tvUcl.text = it.ucl
            bind.tvFa.text = it.fa
            bind.ivPoto.setImageResource(it.poto)
            bind.desc.text = it.desc
        }
    }
}