package com.oguzhanozgokce.musicsplayer.util

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic

object MusicPlayer {

    private var exoplayer: ExoPlayer? = null
    private var currentSong: RoomMusic? = null

    fun getCurrentSong(): RoomMusic? {
        return currentSong
    }

    fun getInstance(): ExoPlayer? {
        return exoplayer
    }
    fun startPlaying(context: Context, music: RoomMusic) {
        if (exoplayer == null) {
            exoplayer = ExoPlayer.Builder(context).build()
        }
        if (currentSong != music) {
            currentSong = music
            currentSong?.songUrl?.apply {
                val mediaItem = MediaItem.fromUri(this)
                exoplayer?.setMediaItem(mediaItem)
                exoplayer?.prepare()
                exoplayer?.playWhenReady = true
                exoplayer?.play()
            }
        }
    }

    fun stopMusic() {
        exoplayer?.stop()
    }

    fun releasePlayer() {
        exoplayer?.release()
        exoplayer = null
    }

}