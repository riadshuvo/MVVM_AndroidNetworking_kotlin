package com.example.mvvm_architecture_beginners.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_architecture_beginners.R
import com.example.mvvm_architecture_beginners.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.ArrayList

class MainAdapter(private val userList: ArrayList<User>, val context: Context ) :
    RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    fun addData(list: List<User>){
        userList.addAll(list)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun buildView(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val myView = ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
        return myView
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.buildView(userList[position])
        holder.itemView.setOnClickListener(){
            Toast.makeText(context,userList[position].id.toString() , Toast.LENGTH_SHORT).show()

        }
    }


}