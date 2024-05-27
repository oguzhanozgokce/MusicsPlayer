package com.oguzhanozgokce.musicsplayer.di

import com.google.firebase.firestore.FirebaseFirestore
import com.oguzhanozgokce.musicsplayer.data.local.MusicDao
import com.oguzhanozgokce.musicsplayer.repository.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMusicRepository(
        musicDao: MusicDao,
        firestore: FirebaseFirestore
    ): MusicRepository {
        return MusicRepository(musicDao, firestore)
    }

}