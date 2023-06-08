package com.example.dummyapplication.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyapplication.R
import com.example.dummyapplication.data.local.PostEntity

class Adapter(private val postList: List<PostEntity>, private val item:((String)->Unit)) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.postitem, parent, false)
        return MyViewHolder(itemView,item)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPost = postList[position]
        holder.title.text = currentPost.title
    }

    class MyViewHolder(itemView: View, item:((String)->Unit)) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)

        var hold = itemView.findViewById<View>(R.id.cardView)
        init {
            hold.setOnClickListener {
                item(title.text.toString())
            }
        }
    }
}