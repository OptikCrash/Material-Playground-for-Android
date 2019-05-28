package com.digitalrelay.materialplayground.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.digitalrelay.materialplayground.fragments.*

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var wordUpdated: String? = null

    //call this method to update fragments in ViewPager dynamically
    fun update(word: String) {
        this.wordUpdated = word
        notifyDataSetChanged()
    }

    override fun getItemPosition(`object`: Any): Int {
        //don't return POSITION_NONE, avoid fragment recreation.
        return super.getItemPosition(`object`)
    }

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var frag: Fragment? = null
        when (position) {
            0 -> frag = TextFragment.newInstance("", "")
            1 -> frag = CardFragment.newInstance("", "")
            2 -> frag = UIFragment.newInstance("", "")
            3 -> frag = ChatFragment.newInstance("", "")
            else -> {
            }
        }
        return frag as Fragment
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Text"
            1 -> return "Card"
            2 -> return "UI"
            3 -> return "Chat"
        }
        return null
    }
}