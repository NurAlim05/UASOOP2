package com.phb.crudapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RVAdapterToko(val context: Context, val items: ArrayList<Toko>) : RecyclerView.Adapter<RVAdapterToko.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: Toko){
            itemView.namaToko.text = items.nama
            itemView.alamatToko.text = items.alamat
            itemView.nohpToko.text = items.nohp

            itemView.btnEdit.setOnClickListener {
                itemView.context.startActivity<MainActivity>(
                    "oldNama" to items.nama,
                    "oldAlamat" to items.alamat,
                    "oldNohp" to items.nohp
                )
            }

            itemView.btnHapus.setOnClickListener {
                itemView.context.database.use {
                    delete(
                        Toko.TABLE_TOKO, "${Toko.NAMA} = {nama})",
                        "nama" to items.nama.toString()
                    )
                }
                itemView.context.toast("Data Dihapus")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }


}
