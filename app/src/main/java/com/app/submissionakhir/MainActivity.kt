package com.app.submissionakhir

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.submissionakhir.adapter.ClubAdapter
import com.app.submissionakhir.model.Club

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private val listClub = ArrayList<Club>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profile: ImageView = findViewById(R.id.ivProfile)
        profile.setOnClickListener{
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)

        listClub.addAll(getListClub())
        setRvList()
    }

    @SuppressLint("Recycle")
    private fun getListClub(): ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataStad = resources.getStringArray(R.array.data_stadium)
        val dataEpl = resources.getStringArray(R.array.data_epl)
        val dataUcl = resources.getStringArray(R.array.data_ucl)
        val dataFa = resources.getStringArray(R.array.data_fa)
        val dataPhoto = resources.obtainTypedArray(R.array.data_poto)
        val listClub = ArrayList<Club>()
        for (i in dataName.indices) {
            val club = Club(dataName[i], dataDesc[i], dataStad[i], dataEpl[i], dataUcl[i], dataFa[i] ,dataPhoto.getResourceId(i, -1))
            listClub.add(club)
        }
    return listClub
    }

    private fun setRvList() {
        rv.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ClubAdapter(listClub)
        rv.adapter = listClubAdapter
    }
}