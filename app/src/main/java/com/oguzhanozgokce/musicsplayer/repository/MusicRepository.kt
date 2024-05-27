package com.oguzhanozgokce.musicsplayer.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.oguzhanozgokce.musicsplayer.data.local.MusicDao
import com.oguzhanozgokce.musicsplayer.data.model.Artist
import com.oguzhanozgokce.musicsplayer.data.model.FirebaseArtist
import com.oguzhanozgokce.musicsplayer.data.model.FirebaseCategory
import com.oguzhanozgokce.musicsplayer.data.model.RoomCategory
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
            list.add(RoomCategory(name = firebaseCategory.name, image = firebaseCategory.category_url))
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
}
