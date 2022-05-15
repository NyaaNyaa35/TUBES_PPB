package com.example.ppb_tubes.AgentView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.ppb_tubes.R
import com.example.ppb_tubes.SideNavFragment

class Cypher : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cypher)

        val sideNav: ImageView = findViewById(R.id.side_nav)
        sideNav.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.side_nav -> {
                val mFragmentManager = supportFragmentManager
                val mSideNavFragment = SideNavFragment()

                val rootView: ViewGroup = findViewById(R.id.cypher_layout)
                val mFade: androidx.transition.Fade =
                    androidx.transition.Fade(androidx.transition.Fade.IN)
                TransitionManager.beginDelayedTransition(rootView, mFade)

                mFragmentManager
                    .beginTransaction()
                    .add(
                        R.id.cypher_layout, mSideNavFragment,
                        SideNavFragment::class.java.simpleName
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}