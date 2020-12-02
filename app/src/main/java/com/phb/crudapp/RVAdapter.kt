package com.phb.crudapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.toast

class RVAdapter(val context: Context, val items: ArrayList<Santri>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(items: Santri){
            itemView.namaSantri.text = items.nama
            itemView.alamatSantri.text = items.alamat
            itemView.handphoneSantri.text = items.handphone

            itemView.btnEdit.setOnClickListener {
                itemView.context.toast("Data diedit")
            }

            itemView.btnHapus.setOnClickListener {
                itemView.context.toast("Data dihapus")
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size


}