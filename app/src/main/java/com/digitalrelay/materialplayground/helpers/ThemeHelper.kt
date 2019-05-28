package com.digitalrelay.materialplayground.helpers

import com.digitalrelay.materialplayground.R
import com.digitalrelay.materialplayground.models.Theme


object ThemeHelper {
    const val THEME_RED : Int = 0
    const val THEME_PINK : Int = 1
    const val THEME_PURPLE : Int = 2
    const val THEME_DEEPPURPLE : Int = 3
    const val THEME_INDIGO : Int = 4
    const val THEME_BLUE : Int = 5
    const val THEME_LIGHTBLUE : Int = 6
    const val THEME_CYAN : Int = 7
    const val THEME_TEAL : Int = 8
    const val THEME_GREEN : Int = 9
    const val THEME_LIGHTGREEN : Int = 10
    const val THEME_LIME : Int = 11
    const val THEME_YELLOW : Int = 12
    const val THEME_AMBER : Int = 13
    const val THEME_ORANGE : Int = 14
    const val THEME_DEEPORANGE : Int = 15
    const val THEME_BROWN : Int = 16
    const val THEME_GRAY : Int = 17
    const val THEME_BLUEGRAY : Int = 18
    const val THEME_WDFW : Int = 19

    fun getThemeId(theme: Int) : Int {
        var themeId = 19
        when (theme) {
            THEME_RED -> themeId = R.style.AppTheme_RED
            THEME_PINK -> themeId = R.style.AppTheme_PINK
            THEME_PURPLE -> themeId = R.style.AppTheme_PURPLE
            THEME_DEEPPURPLE -> themeId = R.style.AppTheme_DEEPPURPLE
            THEME_INDIGO -> themeId = R.style.AppTheme_INDIGO
            THEME_BLUE -> themeId = R.style.AppTheme_BLUE
            THEME_LIGHTBLUE -> themeId = R.style.AppTheme_LIGHTBLUE
            THEME_CYAN -> themeId = R.style.AppTheme_CYAN
            THEME_TEAL -> themeId = R.style.AppTheme_TEAL
            THEME_GREEN -> themeId = R.style.AppTheme_GREEN
            THEME_LIGHTGREEN -> themeId = R.style.AppTheme_LIGHTGREEN
            THEME_LIME -> themeId = R.style.AppTheme_LIME
            THEME_YELLOW -> themeId = R.style.AppTheme_YELLOW
            THEME_AMBER -> themeId = R.style.AppTheme_AMBER
            THEME_ORANGE -> themeId = R.style.AppTheme_ORANGE
            THEME_DEEPORANGE -> themeId = R.style.AppTheme_DEEPORANGE
            THEME_BROWN -> themeId = R.style.AppTheme_BROWN
            THEME_GRAY -> themeId = R.style.AppTheme_GRAY
            THEME_BLUEGRAY -> themeId = R.style.AppTheme_BLUEGRAY
            THEME_WDFW -> themeId = R.style.AppTheme_WDFW
            else -> {
            }
        }
        return themeId
    }
    fun getThemeList() : MutableList<Theme> {
        val themeArrayList = mutableListOf<Theme>()
        themeArrayList.add(Theme(0, R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed))
        themeArrayList.add(Theme(1, R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink))
        themeArrayList.add(Theme(2, R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple))
        themeArrayList.add(Theme(3, R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple))
        themeArrayList.add(Theme(4, R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo))
        themeArrayList.add(Theme(5, R.color.primaryColorBlue, R.color.primaryDarkColorBlue, R.color.secondaryColorBlue))
        themeArrayList.add(Theme(6, R.color.primaryColorLightBlue, R.color.primaryDarkColorLightBlue, R.color.secondaryColorLightBlue))
        themeArrayList.add(Theme(7, R.color.primaryColorCyan, R.color.primaryDarkColorCyan, R.color.secondaryColorCyan))
        themeArrayList.add(Theme(8, R.color.primaryColorTeal, R.color.primaryDarkColorTeal, R.color.secondaryColorTeal))
        themeArrayList.add(Theme(9, R.color.primaryColorGreen, R.color.primaryDarkColorGreen, R.color.secondaryColorGreen))
        themeArrayList.add(Theme(10, R.color.primaryColorLightGreen, R.color.primaryDarkColorLightGreen, R.color.secondaryColorLightGreen))
        themeArrayList.add(Theme(11, R.color.primaryColorLime, R.color.primaryDarkColorLime, R.color.secondaryColorLime))
        themeArrayList.add(Theme(12, R.color.primaryColorYellow, R.color.primaryDarkColorYellow, R.color.secondaryColorYellow))
        themeArrayList.add(Theme(13, R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber))
        themeArrayList.add(Theme(14, R.color.primaryColorOrange, R.color.primaryDarkColorOrange, R.color.secondaryColorOrange))
        themeArrayList.add(Theme(15, R.color.primaryColorDeepOrange, R.color.primaryDarkColorDeepOrange, R.color.secondaryColorDeepOrange))
        themeArrayList.add(Theme(16, R.color.primaryColorBrown, R.color.primaryDarkColorBrown, R.color.secondaryColorBrown))
        themeArrayList.add(Theme(17, R.color.primaryColorGray, R.color.primaryDarkColorGray, R.color.secondaryColorGray))
        themeArrayList.add(Theme(18, R.color.primaryColorBlueGray, R.color.primaryDarkColorBlueGray, R.color.secondaryColorBlueGray))
        themeArrayList.add(Theme(19, R.color.primaryColorWDFW, R.color.primaryDarkColorWDFW, R.color.secondaryColorWDFW))
        return themeArrayList
    }
}