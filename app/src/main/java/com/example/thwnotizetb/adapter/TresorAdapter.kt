package com.example.thwnotizetb.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thwnotizetb.R



class TresorAdapter {


   private var dataset = listOf<Tresor>()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val viewTresor : RecyclerView = view.findViewById(R.id.tresor_rv)
        val hinzu : Button = view.findViewById(R.id.hinzuf_bt)
        val entf : Button = view.findViewById(R.id.entfernen_bt)
        val passId : TextView = view.findViewById(R.id.pWid_tv)
        val passBesch : TextView = view.findViewById(R.id.pWbeschreib_tv)
        val passWort: TextView = view.findViewById(R.id.pW_Pw_tv)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(TresorList: List<Tresor>) {
        treList.also { dataset = it }
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tresor, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        dataset[position]



        holder.passId.text = dataset[position].id.toString()
        holder.passBesch.text = dataset[position].getString()
        holder.passWort.text = dataset[position].getString()
        holder.viewTresor.recycledViewPool



    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}