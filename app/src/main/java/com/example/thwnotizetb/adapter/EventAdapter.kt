package com.example.thwnotizetb.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.Event


class EventAdapter {

    private var dataset = listOf<Event>()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        var title : TextView = view.findViewById(R.id.etTermin)
        var description : TextView = view.findViewById(R.id.etBeschreibung)
        var eventLocation : TextView = view.findViewById(R.id.etOrt)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(addEvent: List<Event>) {
        addEvent.also { dataset = it }

    }

    // hier werden neue ViewHolder erstellt
     fun onCreateViewHolder(parent: ViewGroup): ItemViewHolder {
        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_calender, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        dataset[position]

        /*holder.image.load(rec.image) {
             transformations(CircleCropTransformation())
         }*/

        holder.title.text= dataset[position].title
        holder.eventLocation.text = dataset[position].location
        holder.description.text = dataset[position].description
    }

    // damit der LayoutManager weiß wie lang die Liste ist
     fun getItemCount(): Int {
        return dataset.size
    }
}

