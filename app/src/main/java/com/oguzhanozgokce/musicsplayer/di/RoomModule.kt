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

    val MIGRATION_4_5 = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("""
                CREATE TABLE IF NOT EXISTS `songs` (
                    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    `imageUrl` TEXT NOT NULL,
                    `mediaId` TEXT NOT NULL,
                    `songUrl` TEXT NOT NULL,
                    `title` TEXT NOT NULL,
                    `subtitle` TEXT NOT NULL
                )
            """)
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
    ).fallbackToDestructiveMigration().addMigrations(MIGRATION_4_5).build()


    @Provides
    @Singleton
    fun provideMusicDao(db: MusicDatabase) = db.musicDao()

}