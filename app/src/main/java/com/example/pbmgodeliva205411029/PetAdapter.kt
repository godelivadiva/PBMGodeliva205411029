package com.example.pbmgodeliva205411029

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class PetAdapter(private val petdata: ArrayList<Pet>) :
    RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class PetViewHolder(val view: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val imagePet: ImageView = view.findViewById(R.id.imagePet)
        val textPetName: TextView = view.findViewById(R.id.textPetName)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetAdapter.PetViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.pet_list, parent, false)
        return PetViewHolder(layout, mListener)
    }

    override fun onBindViewHolder(holder: PetAdapter.PetViewHolder, position: Int) {


        val item = petdata[position]
        if (item != null) {
            holder.textPetName.text = item.petName
            holder.imagePet.setImageResource(item.petImage)
        }
    }

    override fun getItemCount(): Int {
        return petdata.size
    }

}