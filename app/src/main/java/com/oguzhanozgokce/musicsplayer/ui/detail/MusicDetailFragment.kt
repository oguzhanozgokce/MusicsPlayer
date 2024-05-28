package com.oguzhanozgokce.musicsplayer.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.oguzhanozgokce.musicsplayer.databinding.FragmentMusicDetailBinding
import com.oguzhanozgokce.musicsplayer.util.MusicPlayer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicDetailFragment : Fragment() {
    private lateinit var binding: FragmentMusicDetailBinding
    private val args: MusicDetailFragmentArgs by navArgs()
    lateinit var exoPlayer: ExoPlayer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val music = args.music
        if (music != null) {
            MusicPlayer.getCurrentSong()?.apply {
                binding.apply {
                    twArtistName.text = title
                    twSongName.text = subtitle
                    Glide.with(root.context).load(imageUrl).circleCrop().into(iwMusicImageId)
                }
                exoPlayer = MusicPlayer.getInstance()!!
                exoPlayer.playWhenReady = true
                binding.playerView.player = exoPlayer
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        MusicPlayer.stopMusic()
        MusicPlayer.releasePlayer()
    }


}