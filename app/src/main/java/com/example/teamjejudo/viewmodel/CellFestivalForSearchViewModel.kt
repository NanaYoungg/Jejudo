package com.example.teamjejudo.viewmodel

import com.example.teamjejudo.data.Festival

class CellFestivalForSearchViewModel(items:Festival) {
    private val items = items

    val festivalTitle:String
        get() = items.festivalTitle
}