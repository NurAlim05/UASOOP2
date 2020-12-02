package com.phb.appcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSimpan.setOnClickListener {
            addDataSantri()
            addDataPonpes()
        }

        buttonLihatData.setOnClickListener {
            toast("Data Di Lihat")
        }

        buttonUpdate.setOnClickListener {
            toast("Data Diupdate")
        }
    }

    private fun addDataSantri() {
        database.use {
            insert(Santri.TABLE_SANTRI,
                Santri.NAMA to editTextNama.text.toString(),
                Santri.ALAMAT to editTextAlamat.text.toString(),
                Santri.HANDPHONE to editTextHandphone.text.toString()
            )
            toast("Data berhasil disimpan!")
        }
    }
    private fun addDataPonpes() {
        database.use {
            insert(Ponpes.TABLE_PONPES,
                Ponpes.PESANTREN to editTextPesantren.text.toString(),
                Ponpes.ALAMATPONPES to editTextAlamatPesantren.text.toString(),
                Ponpes.PENGASUH to editTextPengasuh.text.toString()
            )
            toast("Data berhasil disimpan!")
        }
    }
}