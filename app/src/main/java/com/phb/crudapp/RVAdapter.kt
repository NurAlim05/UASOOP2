package com.phb.crudapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RVAdapter(val context: Context, val items: ArrayList<Santri>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Santri) {
            itemView.namaSantri.text = items.nama
            itemView.alamatSantri.text = items.alamat
            itemView.handphoneSantri.text = items.handphone

            itemView.btnEdit.setOnClickListener {
                itemView.context.startActivity<MainActivity>(
                    "oldNama" to items.nama,
                    "oldAlamat" to items.alamat,
                    "oldHandphone" to items.handphone
                )
            }

            itemView.btnHapus.setOnClickListener {

                itemView.context.database.use {
                    delete(
                        Santri.TABLE_SANTRI, "(${Santri.NAMA} = {nama})",
                        "nama" to items.nama.toString()
                    )
                }
                itemView.context.toast("Data Dihapus")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}