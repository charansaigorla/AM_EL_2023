package com.example.kissangenix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class myadapter(private val userlist : ArrayList<feedDetails>) : RecyclerView.Adapter<myadapter.myviewholder>(){


   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
      return myviewholder((itemView))

   }

   override fun onBindViewHolder(holder: myviewholder, position: Int) {
      var currentitem = userlist[position]
      holder.owner.text = currentitem.owner
      holder.addr.text = currentitem.add
      holder.rentduration.text = currentitem.rd
      holder.rentamount.text = currentitem.ra
      holder.phn.text = currentitem.phn

   }

   override fun getItemCount(): Int {
      return userlist.size
   }

   class myviewholder(itemView : View) : RecyclerView.ViewHolder(itemView){

      val owner : TextView = itemView.findViewById(R.id.owner)
      val addr : TextView = itemView.findViewById(R.id.addr)
      val rentduration : TextView = itemView.findViewById(R.id.rentduration)
      val rentamount : TextView = itemView.findViewById(R.id.rentAmount)
      val phn : TextView = itemView.findViewById(R.id.phn)
   }
}