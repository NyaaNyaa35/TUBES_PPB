package com.example.ppb_tubes.ui.skins.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ppb_tubes.R
import com.example.ppb_tubes.data.local.entity.SkinsEntity
import com.example.ppb_tubes.databinding.AdapterSkinBinding

class SkinAdapter(private val onBookmarkClick: (SkinsEntity) -> Unit) : ListAdapter<SkinsEntity, SkinAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = AdapterSkinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)

        val ivBookmark = holder.binding.ivBookmark
        if (news.isBookmarked) {
            ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    ivBookmark.context,
                    R.drawable.ic_bookmarked_white
                )
            )
        } else {
            ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    ivBookmark.context,
                    R.drawable.ic_bookmark_white
                )
            )
        }
        ivBookmark.setOnClickListener {
            onBookmarkClick(news)
        }
    }

    class MyViewHolder(val binding: AdapterSkinBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(skins: SkinsEntity) {
            Log.e("Skins List : ", skins.displayname)
            binding.tvItemTitle.text = skins.displayname
            Glide.with(itemView.context)
                .load(skins.urlToImage)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(binding.imgPoster)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<SkinsEntity> =
            object : DiffUtil.ItemCallback<SkinsEntity>() {
                override fun areItemsTheSame(oldUser: SkinsEntity, newUser: SkinsEntity): Boolean {
                    return oldUser.displayname == newUser.displayname
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: SkinsEntity, newUser: SkinsEntity): Boolean {
                    return oldUser == newUser
                }
            }
    }
}