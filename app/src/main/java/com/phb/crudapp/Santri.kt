package com.phb.crudapp

data class Santri(var id: Long?, var nama: String?, var alamat: String?, var handphone: String?) {
    companion object {
        const val TABLE_SANTRI: String = "TABLE_SANTRI"
        const val ID: String = "ID_"
        const val NAMA: String = "NAMA"
        const val ALAMAT: String = "ALAMAT"
        const val HANDPHONE: String = "HANDPHONE"
    }
}