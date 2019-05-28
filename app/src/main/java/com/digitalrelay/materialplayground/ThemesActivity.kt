package com.digitalrelay.materialplayground

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_themes.*
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.appcompat.app.AppCompatDelegate
import com.digitalrelay.materialplayground.adapters.SectionsPagerAdapter
import com.digitalrelay.materialplayground.adapters.ThemeAdapter
import com.digitalrelay.materialplayground.helpers.ThemeHelper
import com.digitalrelay.materialplayground.helpers.ThemeHelper.THEME_WDFW
import com.digitalrelay.materialplayground.interfaces.RecyclerViewClickInterface
import com.digitalrelay.materialplayground.models.Theme
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.*
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.android.synthetic.main.bottomsheet_themes.*
import kotlin.coroutines.coroutineContext


class ThemesActivity : AppCompatActivity() {
    private lateinit var adapter : ThemeAdapter
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<View>
    private lateinit var sharedPreferences : SharedPreferences
    private var isNightMode : Boolean = false


    companion object{
        var themeId: Int = THEME_WDFW
        var isInNightMode: Boolean = false
        var themeList : MutableList<Theme> = mutableListOf()
        var selectedTheme: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        themeId = sharedPreferences.getInt("THEME_ID", THEME_WDFW)

        setTheme(ThemeHelper.getThemeId(themeId))
        initViews(savedInstanceState)

        initListeners()
    }

    private fun initViews(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_themes)
        setSupportActionBar(toolbar)

        // get the bottom sheet view
        // init the bottom sheet behavior
        bottomSheetBehavior = from(bottom_sheet_themes)
        bottomSheetBehavior.state = STATE_COLLAPSED

        initBottomSheet()
        prepareThemeData()
//        bottom_sheet_themes.findViewById<ThemeView>(R.id.theme_selected).setTheme(themeList[selectedTheme])

        container.adapter = SectionsPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(container)
    }

    private fun initBottomSheet() {
        val switchCompat : SwitchMaterial = switch_dark_mode
        switchCompat.setOnCheckedChangeListener { compoundButton, b ->
            isNightMode = b
            var delayTime = 200
            if (STATE_EXPANDED == bottomSheetBehavior.state) {
                delayTime = 400
                bottomSheetBehavior.setState(STATE_COLLAPSED)
            }
            compoundButton.postDelayed({
                if (isNightMode) {
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                }
            }, delayTime.toLong())
        }


        adapter = ThemeAdapter(applicationContext, themeList, object : RecyclerViewClickInterface {
            override fun onClick(view: View, position: Int) {
                bottomSheetBehavior.state = STATE_COLLAPSED
                view.postDelayed({ this@ThemesActivity.recreate() }, 400)
            }
        })

        val mLayoutManager = GridLayoutManager(applicationContext, 4)
        theme_recycler.layoutManager = mLayoutManager
        theme_recycler.itemAnimator = DefaultItemAnimator()
        theme_recycler.adapter = adapter
    }

    private fun initListeners() {
        fab.setOnClickListener {
            when (bottomSheetBehavior.state) {
                STATE_HIDDEN -> bottomSheetBehavior.state = STATE_COLLAPSED
                STATE_COLLAPSED -> bottomSheetBehavior.state = STATE_EXPANDED
                STATE_EXPANDED -> bottomSheetBehavior.state = STATE_COLLAPSED
            }
        }

//        theme_selected.setOnClickListener { view ->
//            Toast.makeText(applicationContext, "STUFF aNd things", Toast.LENGTH_SHORT).show()
//        }
    }

    private fun prepareThemeData() {
        themeList.clear()
        themeList.addAll(ThemeHelper.getThemeList())
        adapter.notifyDataSetChanged()
    }

}
