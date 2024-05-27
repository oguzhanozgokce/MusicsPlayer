package com.oguzhanozgokce.musicsplayer.ui.music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oguzhanozgokce.musicsplayer.R
import com.oguzhanozgokce.musicsplayer.data.model.musics.Music
import com.oguzhanozgokce.musicsplayer.data.model.musics.RoomMusic
import com.oguzhanozgokce.musicsplayer.databinding.MusicItemBinding

class SongsAdapter(
    private var songList: List<RoomMusic>)
    : RecyclerView.Adapter<SongsAdapter.SongsViewHolder>() {

    inner class SongsViewHolder(val binding: MusicItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(music: RoomMusic) {
            binding.apply {
                twArtistName.text = music.title
                twSongName.text = music.subtitle
                Glide.with(root.context).load(music.imageUrl).into(iwMusicImageId)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongsViewHolder {
        val binding = MusicItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SongsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongsAdapter.SongsViewHolder, position: Int) {
        holder.bind(songList[position])
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    fun updateSongs(newSongs: List<RoomMusic>){
        songList = newSongs
        notifyDataSetChanged()
    }

}