package com.example.ottapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ottapp.data.model.Data
import com.example.ottapp.databinding.AnimeItemLayoutBinding
import com.example.ottapp.utils.OnItemClickListener

class AnimeListAdapter(
    private val animeList: ArrayList<Data>,

) : RecyclerView.Adapter<AnimeListAdapter.DataViewHolder>() {

    lateinit var itemClickListener: OnItemClickListener<Data>


    class DataViewHolder(private val binding: AnimeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeList: Data , itemClickListener: OnItemClickListener<Data>) {
            binding.textViewTitle.text = animeList.title
            binding.textViewDescription.text = animeList.synopsis
            binding.textViewSource.text = animeList.source

            Glide.with(binding.imageViewBanner)
                .load(animeList.images.jpg.image_url)
                .into(binding.imageViewBanner)


            itemView.setOnClickListener {
                itemClickListener(animeList)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        AnimeItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = animeList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(animeList[position] , itemClickListener)


    fun addData(list: List<Data>) {
        animeList.addAll(list)
    }
}