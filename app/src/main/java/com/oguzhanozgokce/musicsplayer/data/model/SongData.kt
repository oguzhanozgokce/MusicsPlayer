package com.oguzhanozgokce.musicsplayer.data.model

data class SongData(
    val `data`: List<Song>,
    val next: String,
    val total: Int
)