package com.oguzhanozgokce.musicsplayer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oguzhanozgokce.musicsplayer.data.model.Album
import com.oguzhanozgokce.musicsplayer.data.model.Artist
import com.oguzhanozgokce.musicsplayer.data.model.Song

@Database(entities = [Album::class, Artist::class, Song::class], version = 1)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}