package com.oguzhanozgokce.musicsplayer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class RoomCategory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image")
    val image: String
)
