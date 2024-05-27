package com.oguzhanozgokce.musicsplayer.ui.music

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oguzhanozgokce.musicsplayer.data.model.artist.Artist
import com.oguzhanozgokce.musicsplayer.databinding.ArtistItemBinding

class ArtistAdapter(private  val artistList: List<Artist>)
    : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    inner class ArtistViewHolder(val binding: ArtistItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(artist: Artist) {
            binding.apply {
                twArtistName.text = artist.name
                Glide.with(root.context).load(artist.image).into(iwArtistImageId)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistAdapter.ArtistViewHolder {
        val binding = ArtistItemBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistAdapter.ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}