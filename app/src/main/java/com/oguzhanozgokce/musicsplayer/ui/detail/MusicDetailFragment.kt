package com.oguzhanozgokce.musicsplayer.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oguzhanozgokce.musicsplayer.R
import com.oguzhanozgokce.musicsplayer.databinding.FragmentMusicDetailBinding

class MusicDetailFragment : Fragment() {
    private lateinit var binding: FragmentMusicDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}