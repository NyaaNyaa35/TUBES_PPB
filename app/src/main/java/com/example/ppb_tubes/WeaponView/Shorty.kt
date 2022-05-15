package com.example.ppb_tubes.WeaponView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.transition.TransitionManager
import com.example.ppb_tubes.R
import com.example.ppb_tubes.SideNavFragment

class Shorty : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "42da8ccc-40d5-affc-beec-15aa47b42eda"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shorty)

        val sideNav: ImageView = findViewById(R.id.side_nav)
        sideNav.setOnClickListener(this)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.side_nav -> {
                val mFragmentManager = supportFragmentManager
                val mSideNavFragment = SideNavFragment()

                val rootView: ViewGroup = findViewById(R.id.shorty_layout)
                val mFade: androidx.transition.Fade =
                    androidx.transition.Fade(androidx.transition.Fade.IN)
                TransitionManager.beginDelayedTransition(rootView, mFade)

                mFragmentManager
                    .beginTransaction()
                    .add(
                        R.id.shorty_layout, mSideNavFragment,
                        SideNavFragment::class.java.simpleName
                    )
                    .addToBackStack(null)
                    .commit()
            }
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@Shorty,
//                    SkinActivity::class.java
//                )
//                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}