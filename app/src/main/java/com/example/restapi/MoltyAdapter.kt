package com.example.restapi

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.restapi.R.*
import org.w3c.dom.Text

class MoltyAdapter(val data:List<ResultsItem?>?) : RecyclerView.Adapter<MoltyAdapter.MyViewHolder>() {
    class MyViewHolder (view:View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(id.img_view)
        val name = view.findViewById<TextView>(id.text_name)
        val gender = view.findViewById<TextView>(id.text_gender)
        val origin = view.findViewById<TextView>(id.text_origin)
        val status = view.findViewById<TextView>(id.text_status)
        val createed = view.findViewById<TextView>(id.text_crated)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(data != null){
            return data.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data?.get(position)?.name
        holder.gender.text = data?.get(position)?.gender
        holder.origin.text = data?.get(position)?.origin?.name
        holder.status.text = data?.get(position)?.status
        holder.createed.text = data?.get(position)?.created
        Glide.with(holder.img)
            .load(data?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            val name = data?.get(position)?.name
            Toast.makeText(holder.itemView.context, "Ini adalah $name", Toast.LENGTH_SHORT).show()
        }
    }

}