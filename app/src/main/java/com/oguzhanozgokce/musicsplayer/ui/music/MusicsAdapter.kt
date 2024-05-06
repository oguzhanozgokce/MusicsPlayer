package com.oguzhanozgokce.musicsplayer.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oguzhanozgokce.musicsplayer.R
import com.oguzhanozgokce.musicsplayer.data.local.MusicDao
import com.oguzhanozgokce.musicsplayer.data.model.Song
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//  music_item layoutunu bağlamak için gerekli olan adapter sınıfı apiden gelen müsizkleri gösterir
//  OnClick fonksiyonu ile tıklanan müziği alır ve o müziği çalar


class MusicsAdapter(
    private val musicList: List<Song>,
    private val onItemClickListener: (position: Int) -> Unit
) : RecyclerView.Adapter<MusicsAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iw_music_image_id)
        val songName: TextView = itemView.findViewById(R.id.tw_song_name)
        val artistName: TextView = itemView.findViewById(R.id.tw_artist_name)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem = musicList[position]
        Glide.with(holder.itemView.context)
            .load(currentItem.md5_image)
            .into(holder.imageView)
        holder.songName.text = currentItem.title
        /**CoroutineScope(Dispatchers.IO).launch {
            val artist = artistDao.getArtistById(currentItem.artistId)
            withContext(Dispatchers.Main) {
                holder.artistName.text = artist.name
            }
        } */
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}