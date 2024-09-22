package com.app.submissionakhir.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.submissionakhir.DetailActivity
import com.app.submissionakhir.databinding.ListItemBinding
import com.app.submissionakhir.model.Club
import com.bumptech.glide.Glide

class ClubAdapter(private val listClub: ArrayList<Club>) : RecyclerView.Adapter<ClubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val bind = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(bind)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val club = listClub[position]
        holder.bind.tvJudul.text = club.name
        holder.bind.tvDesc.text = club.desc
        Glide.with(holder.itemView.context)
            .load(club.poto)
            .into(holder.bind.ivPhoto)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("key_club", listClub[holder.adapterPosition])
            v.context.startActivity(intent)
        }
    }

    class ListViewHolder(val bind: ListItemBinding): RecyclerView.ViewHolder(bind.root)
}