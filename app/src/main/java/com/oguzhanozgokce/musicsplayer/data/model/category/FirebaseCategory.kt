package com.oguzhanozgokce.musicsplayer.data.model.category

data class FirebaseCategory(
    val name: String = "",
    val category_url: String = "",
    val songs : List<String> = listOf()
)
