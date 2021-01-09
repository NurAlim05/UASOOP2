package com.phb.crudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phb.crudapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.update
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var oldMerk = intent.getStringExtra("oldMerk")
        var oldWarna = intent.getStringExtra("oldWarna")
        var oldHarga = intent.getStringExtra("oldHarga")
        var oldNama = intent.getStringExtra("oldNama")
        var oldAlamat = intent.getStringExtra("oldAlamat")
        var oldNoHp = intent.getStringExtra("oldNoHpToko")

        if (oldWarna.isNullOrBlank()){
            buttonUpdate.isEnabled = false
        }else{
            buttonSimpan.isEnabled = false
            editTextMerk.setText(oldMerk)
            editTextWarna.setText(oldWarna)
            editTextHarga.setText(oldHarga)
            editTextNama.setText(oldNama)
            editTextAlamat.setText(oldAlamat)
            editTextNohp.setText(oldNoHp)

        }

        buttonSimpan.setOnClickListener {
            addDataLaptop()
            addDataToko()

            // clear data
            clearData()
        }

        buttonLihatData.setOnClickListener {
            startActivity<ListLaptopActivity>()
            startActivity<ListTokoActivity>()
        }

        buttonUpdate.setOnClickListener {
            database.use {
                update(Laptop.TABLE_LAPTOP,
                    Laptop.MERK to editTextMerk.text.toString(),
                    Laptop.WARNA to editTextWarna.text.toString(),
                    Laptop.HARGA to editTextHarga.text.toString())
                    .whereArgs("${Laptop.MERK} = {merk}",
                        "merk" to oldMerk
                    ).exec()
                update(Toko.TABLE_TOKO,
                    Toko.NAMA to editTextNama.text.toString(),
                    Toko.ALAMAT to editTextAlamat.text.toString(),
                    Toko.NOHP to editTextNohp.text.toString())
                    .whereArgs("${Toko.NAMA} = {nama}",
                        "nama" to oldNama
                    ).exec()
            }
            // clear data
            clearData()
            toast("Data berhasil di update!")
        }
    }

    private fun addDataLaptop() {
        database.use {
            insert(Laptop.TABLE_LAPTOP,
                Laptop.MERK to editTextMerk.text.toString(),
                Laptop.WARNA to editTextWarna.text.toString(),
                Laptop.HARGA to editTextHarga.text.toString()
            )
            toast("Data berhasil disimpan!")
        }
    }
    private fun addDataToko() {
        database.use {
            insert(Toko.TABLE_TOKO,
                Toko.NAMA to editTextNama.text.toString(),
                Toko.ALAMAT to editTextAlamat.text.toString(),
                Toko.NOHP to editTextNohp.text.toString()
            )
            toast("Data berhasil disimpan!")
        }
    }
    fun clearData(){
        editTextMerk.text.clear()
        editTextWarna.text.clear()
        editTextHarga.text.clear()
        editTextNama.text.clear()
        editTextAlamat.text.clear()
        editTextNohp.text.clear()
    }
}