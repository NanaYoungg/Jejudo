package com.example.teamjejudo.viewmodel

import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.FestivalEx

class CellFestivalForSearchViewModel(items:FestivalEx) {
    private val items = items

    val festivalTitle:String
        get() = items.festivalTitle
}