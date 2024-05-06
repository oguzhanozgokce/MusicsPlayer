package com.oguzhanozgokce.musicsplayer.ui.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oguzhanozgokce.musicsplayer.R
import com.oguzhanozgokce.musicsplayer.databinding.FragmentMusicListBinding


class MusicListFragment : Fragment() {
    private lateinit var binding: FragmentMusicListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        return binding.root
    }
}