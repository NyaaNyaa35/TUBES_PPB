package com.example.ppb_tubes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.ppb_tubes.ui.skins.allskins.SkinActivity

class SideNavFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_side_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backToMain: ImageView = view.findViewById(R.id.close_side_nav)
        backToMain.setOnClickListener(this)

        val goToHomeScreen: LinearLayout = view.findViewById(R.id.home)
        goToHomeScreen.setOnClickListener(this)

        val goToAgent: LinearLayout = view.findViewById(R.id.agent)
        goToAgent.setOnClickListener(this)

        val goToWeapon: LinearLayout = view.findViewById(R.id.weapon)
        goToWeapon.setOnClickListener(this)

        val goToSkin: LinearLayout = view.findViewById(R.id.skin)
        goToSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.close_side_nav -> {
                activity?.onBackPressed()
            }
            R.id.home -> {
                val intentHomeScreen = Intent (activity, HomeScreen::class.java)
                activity?.startActivity(intentHomeScreen)
            }
            R.id.agent -> {
                val intentAgent = Intent (activity, Agent::class.java)
                activity?.startActivity(intentAgent)
            }
            R.id.weapon -> {
                val intentAgent = Intent (activity, Weapon::class.java)
                activity?.startActivity(intentAgent)
            }
            R.id.skin -> {
                val intentAgent = Intent (activity, SkinActivity::class.java)
                activity?.startActivity(intentAgent)
            }
        }
    }

}