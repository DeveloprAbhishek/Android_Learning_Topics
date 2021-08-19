package com.example.kotlin_scoping_functions_you_19aug21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(var list: List<Data>) : RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.users_item_layout, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val data: Data = list.get(position)
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}