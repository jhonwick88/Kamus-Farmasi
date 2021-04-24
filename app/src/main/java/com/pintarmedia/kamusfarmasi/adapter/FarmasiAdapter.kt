package com.pintarmedia.kamusfarmasi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pintarmedia.kamusfarmasi.R
import com.pintarmedia.kamusfarmasi.model.Farmasi
import kotlinx.android.synthetic.main.item_farmasi.view.*

class FarmasiAdapter(val itemClick: (Farmasi) -> Unit ) : RecyclerView.Adapter<FarmasiAdapter.ViewHolder>() {

    var data: MutableList<Farmasi> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_farmasi,
                parent,
                false
            ), itemClick
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View, val itemClick: (Farmasi) -> Unit ) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Farmasi) = with(item) {
            itemView.itemIstilah.text = istilah
            itemView.itemArti.text = arti
            itemView.setOnClickListener{ itemClick(this) }
        }


    }
}