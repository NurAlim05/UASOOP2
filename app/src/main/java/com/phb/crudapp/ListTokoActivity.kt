package com.phb.crudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.phb.crudapp.R.*
import kotlinx.android.synthetic.main.activity_list_toko.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListTokoActivity : AppCompatActivity() {

    private lateinit var adapter: RVAdapterToko
    private var toko = ArrayList<Toko>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_toko)

        adapter = RVAdapterToko(this, toko)
        recylerViewToko.adapter = adapter

        getData()
        recylerViewToko.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            toko.clear()
            var result = select(Toko.TABLE_TOKO)
            var dataToko = result.parseList(classParser<Toko>())
            toko.addAll(dataToko)
            adapter.notifyDataSetChanged()
        }
    }
}