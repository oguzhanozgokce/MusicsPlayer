package com.oguzhanozgokce.musicsplayer.data.model.musics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class RoomMusic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String = "",
    @ColumnInfo(name = "mediaId")
    val mediaId: String = "",
    @ColumnInfo(name = "songUrl")
    val songUrl: String = "",
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "subtitle")
    val subtitle: String = ""
)
