package com.oguzhanozgokce.musicsplayer.ui.music

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oguzhanozgokce.musicsplayer.data.model.category.RoomCategory
import com.oguzhanozgokce.musicsplayer.databinding.CategoryItemBinding

class CategoryAdapter(
    private val categoryList: List<RoomCategory>
) : RecyclerView.Adapter<CategoryAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(category: RoomCategory) {
            binding.apply {
                twCategoryName.text = category.name
                Glide.with(root.context).load(category.image).into(iwCategoryImageId)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.MusicViewHolder {
        val binding = CategoryItemBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.MusicViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}