package com.example.ottapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ottapp.data.model.Data
import com.example.ottapp.databinding.AnimeItemLayoutBinding

class AnimeListAdapter(
    private val animeList: ArrayList<Data>
  ) : RecyclerView.Adapter<AnimeListAdapter.DataViewHolder>() {


    class DataViewHolder(private val binding: AnimeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeList: Data) {
            println("Vikash Data: ${animeList.images.jpg.image_url}")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        AnimeItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = animeList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(animeList[position])

    fun addData(list: List<Data>) {
        animeList.addAll(list)
    }
}