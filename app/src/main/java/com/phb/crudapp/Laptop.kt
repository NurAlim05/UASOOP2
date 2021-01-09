package com.phb.crudapp

data class Laptop(var id: Long?, var merk: String?, var warna: String?, var harga: String?) {
    companion object {
        const val TABLE_LAPTOP: String = "TABLE_LAPTOP"
        const val ID: String = "ID_"
        const val MERK: String = "MERK"
        const val WARNA: String = "WARNA"
        const val HARGA: String = "HARGA"
    }
}