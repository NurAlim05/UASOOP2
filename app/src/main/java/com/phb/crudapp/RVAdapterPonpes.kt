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

class RVAdapterPonpes(val context: Context, val items: ArrayList<Ponpes>) : RecyclerView.Adapter<RVAdapterPonpes.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){


        fun bindItem(items: Ponpes){
            itemView.namaPesantren.text = items.pesantren
            itemView.alamatPesantren.text = items.alamatponpes
            itemView.pengasuhPesantren.text = items.pengasuh

            itemView.btnEdit.setOnClickListener {
                itemView.context.toast("Data Di Edit")
            }

            itemView.btnHapus.setOnClickListener {
                itemView.context.database.use {
                    delete(
                        Ponpes.TABLE_PONPES, "${Ponpes.PESANTREN} = {pesantren})",
                        "pesantren" to items.pesantren.toString()
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
