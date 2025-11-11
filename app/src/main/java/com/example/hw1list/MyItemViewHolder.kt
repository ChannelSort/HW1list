package com.example.hw1list

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val item: TextView = itemView.findViewById(R.id.item)

    fun bind(item: Item, onClick: (Int) -> Unit) {
        this.item.text = item.num.toString()
        val color = if (item.num % 2 == 0) {
            ContextCompat.getColor(itemView.context, R.color.red)
        } else {
            ContextCompat.getColor(itemView.context, R.color.blue)
        }
        this.item.setBackgroundColor(color)
        this.item.setOnClickListener { onClick(item.num) }
    }
}