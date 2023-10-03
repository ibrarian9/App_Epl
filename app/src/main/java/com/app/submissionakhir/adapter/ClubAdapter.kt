package com.app.submissionakhir.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.submissionakhir.DetailActivity
import com.app.submissionakhir.R
import com.app.submissionakhir.model.Club
import com.bumptech.glide.Glide

class ClubAdapter(private val listClub: ArrayList<Club>) : RecyclerView.Adapter<ClubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, stadium, epl, ucl, fa, poto) = listClub[position]
        holder.nama.text = name
        holder.desc.text = desc
        Glide.with(holder.itemView.context)
            .load(poto)
            .into(holder.poto)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("desc", desc)
            intent.putExtra("stadium", stadium)
            intent.putExtra("epl", epl)
            intent.putExtra("ucl", ucl)
            intent.putExtra("fa", fa)
            intent.putExtra("poto", poto)
            v.context.startActivity(intent)
        }
    }

    class ListViewHolder(v : View): RecyclerView.ViewHolder(v) {
        val nama: TextView = v.findViewById(R.id.tvJudul)
        val desc: TextView = v.findViewById(R.id.tvDesc)
        val poto: ImageView = v.findViewById(R.id.ivPhoto)
    }
}