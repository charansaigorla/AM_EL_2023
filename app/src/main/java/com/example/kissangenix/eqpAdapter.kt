package com.example.kissangenix

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class eqpAdapter(private val userList :ArrayList<equipdetails>): RecyclerView.Adapter<eqpAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.equip_item,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]
        holder.eqname.text=currentitem.eqpname
        holder.eqadress.text=currentitem.address
        holder.eqage.text=currentitem.eqpage
        holder.eqrd.text=currentitem.rd
        holder.eqra.text=currentitem.ra
        holder.eqphn.text=currentitem.phn
        Picasso.get().load(currentitem.pic?.toUri()).into(holder.picimg);

    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val eqname: TextView = itemView.findViewById(R.id.eqname)
        val eqadress: TextView = itemView.findViewById(R.id.eqaddress)
        val eqage: TextView = itemView.findViewById(R.id.eqage)
        val eqrd: TextView = itemView.findViewById(R.id.eqrd)
        val eqra: TextView = itemView.findViewById(R.id.eqra)
        val eqphn: TextView = itemView.findViewById(R.id.eqphn)
        val picimg:ImageView = itemView.findViewById(R.id.picimg)
    }
}