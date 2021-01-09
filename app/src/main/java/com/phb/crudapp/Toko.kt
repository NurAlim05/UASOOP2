package com.phb.crudapp

data class Toko(var id: Long?, var nama: String?, var alamat: String?, var nohp: String?) {
    companion object {
        const val TABLE_TOKO: String = "TABLE_TOKO"
        const val ID: String = "ID_"
        const val NAMA: String = "NAMA"
        const val ALAMAT: String = "ALAMAT"
        const val NOHP: String = "NOHP"
    }
}