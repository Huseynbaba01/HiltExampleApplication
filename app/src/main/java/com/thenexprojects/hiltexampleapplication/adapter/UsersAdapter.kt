package com.thenexprojects.hiltexampleapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thenexprojects.hiltexampleapplication.R
import com.thenexprojects.hiltexampleapplication.model.User

class UsersAdapter(private var items:List<User>): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val id: TextView = itemView.findViewById(R.id.id)
        val username: TextView = itemView.findViewById(R.id.username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_user,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].let {
            holder.id.text = it.id.toString()
            holder.username.text = it.username
        }
    }

    override fun getItemCount() = items.size

    fun updateUsers(newUsers: List<User>){
        this.items = newUsers
        notifyDataSetChanged()
    }
}