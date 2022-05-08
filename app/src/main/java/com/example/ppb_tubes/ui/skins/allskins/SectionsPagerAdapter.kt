package com.example.ppb_tubes.ui.skins.allskins

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter internal constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        val fragment = SkinsFragment()
        val bundle = Bundle()
        if (position == 0) {
            bundle.putString(SkinsFragment.ARG_TAB, SkinsFragment.TAB_SKINS)
        } else {
            bundle.putString(SkinsFragment.ARG_TAB, SkinsFragment.TAB_BOOKMARK)
        }
        fragment.arguments = bundle
        Log.e("Argument Section : ",fragment.toString())
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}