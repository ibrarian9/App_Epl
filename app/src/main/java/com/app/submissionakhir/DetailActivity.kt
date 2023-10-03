package com.app.submissionakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        val name = intent.getStringExtra("name")
        val judul: TextView = findViewById(R.id.tvJudul)
        judul.text = name

        val desc = intent.getStringExtra("desc")
        val data: TextView = findViewById(R.id.tvDesc)
        data.text = desc

        val stadium = intent.getStringExtra("stadium")
        val dataStad: TextView = findViewById(R.id.tvStadium)
        dataStad.text = stadium

        val epl = intent.getStringExtra("epl")
        val dataEpl: TextView = findViewById(R.id.tvEpl)
        dataEpl.text = epl

        val ucl = intent.getStringExtra("ucl")
        val dataUcl: TextView = findViewById(R.id.tvUcl)
        dataUcl.text = ucl

        val fa = intent.getStringExtra("fa")
        val dataFa: TextView = findViewById(R.id.tvFa)
        dataFa.text = fa

        val poto = intent.getIntExtra("poto", 0)
        val pott: ImageView = findViewById(R.id.ivPoto)
        pott.setImageResource(poto)

        val dataa: TextView = findViewById(R.id.desc)
        dataa.text = desc



    }
}