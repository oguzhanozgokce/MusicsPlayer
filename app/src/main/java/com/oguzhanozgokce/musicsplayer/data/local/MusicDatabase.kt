package com.oguzhanozgokce.musicsplayer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oguzhanozgokce.musicsplayer.data.model.artist.Artist
import com.oguzhanozgokce.musicsplayer.data.model.category.RoomCategory
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic

@Database(entities = [RoomCategory::class, Artist::class, RoomMusic::class],  version = 5, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}