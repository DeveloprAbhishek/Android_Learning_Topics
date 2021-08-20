package com.example.kotlin_scoping_functions_you_19aug21

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.users_item_layout.view.*

class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(data: Data) {


        itemView.apply {
            data.run {
                tvId.text = id.toString()
                tvEmail.text = email.toString()
                tvFirstName.text = firstName.toString()
                Glide.with(ivUserImage).load(avatar).into(ivUserImage)
            }


            cardView.setOnClickListener {
                val alertDialog = AlertDialog.Builder(it.context)
                alertDialog.setTitle("Users Details")
                alertDialog.setMessage("First Name ${data.firstName}, Email:- ${data.email}")
                alertDialog.setPositiveButton("ok"){ _, _ -> }
                alertDialog.show()
            }
        }
    }
}