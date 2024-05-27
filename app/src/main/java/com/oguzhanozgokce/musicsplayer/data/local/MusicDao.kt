package com.oguzhanozgokce.musicsplayer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oguzhanozgokce.musicsplayer.data.model.artist.Artist
import com.oguzhanozgokce.musicsplayer.data.model.category.RoomCategory
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic

@Dao
interface  MusicDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllCategories(categories: List<RoomCategory>)

        @Query("SELECT * FROM songs WHERE mediaId = :mediaId LIMIT 1")
        suspend fun getMusicByMediaId(mediaId: String): RoomMusic?

        @Query("SELECT * FROM category")
        suspend fun getAllCategories(): List<RoomCategory>

        //----- Artist -----

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllArtists(artists: List<Artist>)

        @Query("SELECT * FROM artist")
        suspend fun getAllArtists(): List<Artist>

        //----- Music -----
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllMusics(musics: List<RoomMusic>)

}