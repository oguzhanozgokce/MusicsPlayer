package com.oguzhanozgokce.musicsplayer.ui.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzhanozgokce.musicsplayer.databinding.FragmentMusicListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MusicListFragment : Fragment() {
    private lateinit var binding: FragmentMusicListBinding
    private val viewModel: MusicViewModel by viewModels()

    private lateinit var adapter: CategoryAdapter
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CategoryAdapterBinding()
        ArtistAdapterBinding()
        // Verileri Firestore'dan çekin ve Room'a ekleyin
        viewModel.fetchCategoriesFromFirestore()
        viewModel.fetchArtistFromFirestore()



    }

    private fun CategoryAdapterBinding(){
        binding.rcCategoriesId.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = CategoryAdapter(listOf())
        binding.rcCategoriesId.adapter = adapter

        viewModel.categories.observe(viewLifecycleOwner, Observer { categories ->
            adapter = CategoryAdapter(categories)
            binding.rcCategoriesId.adapter = adapter
        })
    }

    private fun ArtistAdapterBinding(){
        binding.rcArtistsId.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        artistAdapter = ArtistAdapter(listOf())
        binding.rcArtistsId.adapter = artistAdapter

        viewModel.artists.observe(viewLifecycleOwner, Observer { artists ->
            artistAdapter = ArtistAdapter(artists)
            binding.rcArtistsId.adapter = artistAdapter
        })
    }


}
