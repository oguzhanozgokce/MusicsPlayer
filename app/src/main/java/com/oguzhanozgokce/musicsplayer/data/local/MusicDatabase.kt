package com.oguzhanozgokce.musicsplayer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oguzhanozgokce.musicsplayer.data.model.Artist
import com.oguzhanozgokce.musicsplayer.data.model.RoomCategory

@Database(entities = [RoomCategory::class, Artist::class],  version = 4, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}