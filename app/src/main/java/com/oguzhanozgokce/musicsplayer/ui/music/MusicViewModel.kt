package com.oguzhanozgokce.musicsplayer.ui.music

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhanozgokce.musicsplayer.data.model.artist.Artist
import com.oguzhanozgokce.musicsplayer.data.model.category.RoomCategory
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic
import com.oguzhanozgokce.musicsplayer.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicRepository: MusicRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<RoomCategory>>()
    val categories: LiveData<List<RoomCategory>> = _categories

    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists

    private val _musics = MutableLiveData<List<RoomMusic>>()
    val musics: LiveData<List<RoomMusic>> = _musics

     fun fetchCategoriesFromFirestore() {
        viewModelScope.launch {
            val categories = musicRepository.fetchCategoriesFromFirestore()
            _categories.postValue(categories)
            Log.e("MusicViewModel", "Fetched categories from Firestore")
        }
    }

    fun fetchArtistFromFirestore() {
        viewModelScope.launch {
            val artists = musicRepository.fetchArtistFromFirestore()
            _artists.postValue(artists)
            Log.e("MusicViewModel", "Fetched artists from Firestore")
        }
    }

    fun fetchMusicsFromFirestore() {
        viewModelScope.launch {
            val musics = musicRepository.fetchMusicsFromFirestore()
            _musics.postValue(musics)
            Log.e("MusicViewModel", "Fetched musics from Firestore")
        }
    }
}
