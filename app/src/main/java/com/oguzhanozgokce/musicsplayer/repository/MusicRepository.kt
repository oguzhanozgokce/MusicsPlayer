package com.oguzhanozgokce.musicsplayer.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.oguzhanozgokce.musicsplayer.data.local.MusicDao
import com.oguzhanozgokce.musicsplayer.data.model.artist.Artist
import com.oguzhanozgokce.musicsplayer.data.model.artist.FirebaseArtist
import com.oguzhanozgokce.musicsplayer.data.model.category.FirebaseCategory
import com.oguzhanozgokce.musicsplayer.data.model.category.RoomCategory
import com.oguzhanozgokce.musicsplayer.data.model.musics.Music
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MusicRepository @Inject constructor(
    private val musicDao: MusicDao,
    private val firestore: FirebaseFirestore
) {

    suspend fun insertAllCategories(categories: List<RoomCategory>) {
        musicDao.insertAllCategories(categories)
    }

    suspend fun fetchCategoriesFromFirestore(): List<RoomCategory> {
        val categories = firestore.collection("category").get().await()
        val list = mutableListOf<RoomCategory>()
        for (category in categories) {
            val firebaseCategory = category.toObject(FirebaseCategory::class.java)
            list.add(
                RoomCategory(
                    name = firebaseCategory.name,
                    image = firebaseCategory.category_url
                )
            )
        }
        insertAllCategories(list)
        return list
    }

    suspend fun insertAllArtists(artists: List<Artist>) {
        musicDao.insertAllArtists(artists)
    }

    suspend fun fetchArtistFromFirestore(): List<Artist> {
        val artists = firestore.collection("artist").get().await()
        val list = mutableListOf<Artist>()
        for (artist in artists) {
            val firebaseArtist = artist.toObject(FirebaseArtist::class.java)
            list.add(Artist(name = firebaseArtist.name, image = firebaseArtist.artist_url))
        }
        Log.d("Artist", list.toString())
        insertAllArtists(list)
        return list
    }

    suspend fun insertAllMusics(musics: List<RoomMusic>) {
        musicDao.insertAllMusics(musics)
    }

    suspend fun fetchMusicsFromFirestore(): List<RoomMusic> {
        val musics = firestore.collection("songs").get().await()
        val list = mutableListOf<RoomMusic>()
        for (music in musics) {
            val roomMusic = music.toObject(Music::class.java)
            list.add(
                RoomMusic(
                    imageUrl = roomMusic.imageUrl,
                    mediaId = roomMusic.mediaId,
                    songUrl = roomMusic.songUrl,
                    title = roomMusic.title,
                    subtitle = roomMusic.subtitle
                )
            )
        }
        insertAllMusics(list)
        return list
    }
}
