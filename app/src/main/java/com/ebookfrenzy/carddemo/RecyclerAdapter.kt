package com.ebookfrenzy.carddemo

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight")
    private val details = arrayOf("Item One Details", "Item Two Details", "Item Three Details",
        "Item Four Details", "Item Five Details", "Item Six Details", "Item Seven Details", "Item Eight Details")
    private val images = intArrayOf(R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemTitle = itemView.findViewById(R.id.item_title)

            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition

                Snackbar.make(v, "Click detected on item $position", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}