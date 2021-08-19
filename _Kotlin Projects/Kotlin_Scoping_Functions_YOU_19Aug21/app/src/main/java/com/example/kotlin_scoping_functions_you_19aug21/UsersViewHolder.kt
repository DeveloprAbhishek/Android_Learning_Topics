package com.example.kotlin_scoping_functions_you_19aug21

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.users_item_layout.view.*

class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(data: Data) {
        itemView?.apply {
            tvId.text = data.id.toString()
            tvEmail.text = data.email.toString()
            tvFirstName.text = data.firstName.toString()
            Glide.with(ivUserImage).load(data.avatar).into(ivUserImage)
        }
    }
}