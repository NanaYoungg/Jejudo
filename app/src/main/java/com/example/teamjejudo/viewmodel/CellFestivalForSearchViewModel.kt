package com.example.teamjejudo.viewmodel

import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.FestivalEx
import com.example.teamjejudo.data.Item

class CellFestivalForSearchViewModel(items: Item) {
    private val items = items

    val title:String
        get() = items.title

    val contentid:Int
        get() = items.contentid
}