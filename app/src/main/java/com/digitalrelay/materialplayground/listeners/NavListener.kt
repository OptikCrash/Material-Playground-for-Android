package com.digitalrelay.materialplayground.listeners

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.digitalrelay.materialplayground.MainActivity
import com.digitalrelay.materialplayground.R
import com.digitalrelay.materialplayground.ThemesActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class NavListener(activity: MainActivity): NavigationView.OnNavigationItemSelectedListener {
    private val main: MainActivity = activity

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_themes -> {
                val intent = Intent(main.applicationContext as Context, ThemesActivity::class.java)
                main.startActivity(intent)
            }
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        main.drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}