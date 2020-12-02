package com.phb.appcrud

data class Ponpes(var id: Long?, var pesantren: String?, var alamatponpes: String?, var pengasuh: String?){
    companion object{
        const val TABLE_PONPES: String = "TABLE_PONPES"
        const val ID: String = "ID_"
        const val PESANTREN: String = "PESANTREN"
        const val ALAMATPONPES: String = "ALAMATPONPES"
        const val PENGASUH: String = "PENGASUH"
    }
}