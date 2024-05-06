package com.oguzhanozgokce.musicsplayer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oguzhanozgokce.musicsplayer.data.model.Album
import com.oguzhanozgokce.musicsplayer.data.model.Artist
import com.oguzhanozgokce.musicsplayer.data.model.Song

@Dao
interface  MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<Song>)

    @Query("SELECT * FROM albums")
    suspend fun getAllAlbums(): List<Album>

    @Query("SELECT * FROM albums WHERE id = :id")
    suspend fun getAlbum(id: Int): Album

    @Query("SELECT * FROM songs")
    suspend fun getAllSongs(): List<Song>

    @Query("SELECT * FROM songs WHERE albumId = :albumId")
    suspend fun getSongsByAlbum(albumId: Int): List<Song>

    @Query("SELECT * FROM songs WHERE artistId = :artistId")
    suspend fun getSongsByArtist(artistId: Int): List<Song>

    @Query("SELECT * FROM artists WHERE id = :artistId")
    suspend fun getArtistById(artistId: Int): Artist?


}