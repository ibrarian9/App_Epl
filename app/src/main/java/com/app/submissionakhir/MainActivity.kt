package com.app.submissionakhir

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.submissionakhir.adapter.ClubAdapter
import com.app.submissionakhir.databinding.ActivityMainBinding
import com.app.submissionakhir.model.Club

class MainActivity : AppCompatActivity() {

    private val listClub = ArrayList<Club>()
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.ivProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }

        bind.rv.setHasFixedSize(true)
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
        bind.rv.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ClubAdapter(listClub)
        bind.rv.adapter = listClubAdapter
    }
}