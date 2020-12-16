package com.phb.crudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.activity_list_ponpes.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListPonpesActivity : AppCompatActivity() {

    private lateinit var adapter: RVAdapterPonpes
    private var ponpes = ArrayList<Ponpes>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_ponpes)

        adapter = RVAdapterPonpes(this, ponpes)
        recylerViewPonpes.adapter = adapter

        getData()
        recylerViewPonpes.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            ponpes.clear()
            var result = select(Ponpes.TABLE_PONPES)
            var dataPonpes = result.parseList(classParser<Ponpes>())
            ponpes.addAll(dataPonpes)
            adapter.notifyDataSetChanged()
        }
    }
}