package com.oguzhanozgokce.musicsplayer.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class Album(
    @PrimaryKey val id: Int,
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String
)