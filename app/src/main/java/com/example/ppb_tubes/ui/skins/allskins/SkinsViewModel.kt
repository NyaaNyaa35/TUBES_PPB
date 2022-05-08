package com.example.ppb_tubes.ui.skins.allskins

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ppb_tubes.data.SkinsRepository
import com.example.ppb_tubes.data.local.entity.SkinsEntity
import kotlinx.coroutines.launch

class SkinsViewModel(private val skinsRepository: SkinsRepository) : ViewModel() {
    fun getHeadlineSkins() = skinsRepository.getHeadlineSkins()

    fun getBookmarkedSkins() = skinsRepository.getBookmarkedSkins()

    fun saveSkins(skins: SkinsEntity) {
        viewModelScope.launch {
            skinsRepository.setBookmarkedSkins(skins, true)
        }
    }

    fun deleteSkins(skins: SkinsEntity) {
        viewModelScope.launch {
            skinsRepository.setBookmarkedSkins(skins, false)
        }
    }
}