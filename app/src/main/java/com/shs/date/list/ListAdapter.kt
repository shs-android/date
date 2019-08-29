package com.shs.date.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shs.date.R
import com.shs.date.model.Event

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {
    private var itemList: List<Event> = mutableListOf()

    fun addAll(newList: List<Event>) {
        itemList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleView = view.findViewById<TextView>(R.id.titleTextView)

        fun bind(event: Event) {
            titleView.text = event.title
        }
    }
}