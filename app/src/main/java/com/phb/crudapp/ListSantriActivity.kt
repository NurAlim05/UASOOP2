package com.phb.crudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.activity_list_santri.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListSantriActivity : AppCompatActivity() {

    private lateinit var adapter: RVAdapter
    private var santri = ArrayList<Santri>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_santri)

        adapter = RVAdapter(this, santri)
        recylerView.adapter = adapter

        getData()
        recylerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            santri.clear()
            var result = select(Santri.TABLE_SANTRI)
            var dataSantri = result.parseList(classParser<Santri>())
            santri.addAll(dataSantri)
            adapter.notifyDataSetChanged()
        }
    }
}