package com.oguzhanozgokce.musicsplayer.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.oguzhanozgokce.musicsplayer.data.local.MusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {

        }
    }

    @Provides
    @Singleton
    fun provideRoomDB(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MusicDatabase::class.java,
        "music_database"
    ).fallbackToDestructiveMigration().addMigrations(MIGRATION_3_4).build()


    @Provides
    @Singleton
    fun provideMusicDao(db: MusicDatabase) = db.musicDao()

}