package com.example.ppb_tubes.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppb_tubes.Model.Skins
import com.example.ppb_tubes.Model.Weapons
import com.example.ppb_tubes.R
import kotlinx.android.synthetic.main.adapter_skin.view.*

class SkinAdapter(private val results: ArrayList<Skins>) :
    RecyclerView.Adapter<SkinAdapter.ViewHolder>() {

    fun setData(data: List<Skins>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_skin, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        Log.d("SkinAdapter", "result.displayName: ${result.displayName}")
        holder.view.textView.text = result.displayName
            Glide.with(holder.view)
                .load(result.displayIcon)
                .into(holder.view.weapon_image)
    }

    override fun getItemCount() = results.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}