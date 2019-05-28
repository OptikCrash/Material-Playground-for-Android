package com.digitalrelay.materialplayground.adapters

import android.content.Context
import android.preference.PreferenceManager
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.digitalrelay.materialplayground.R
import com.digitalrelay.materialplayground.models.Theme
import android.view.ViewGroup
import com.digitalrelay.materialplayground.ThemesActivity
import com.digitalrelay.materialplayground.inflate
import com.digitalrelay.materialplayground.interfaces.RecyclerViewClickInterface
import com.digitalrelay.materialplayground.views.ThemeView

class ThemeAdapter(context: Context, themes: MutableList<Theme>, recyclerListener: RecyclerViewClickInterface) : RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder>() {
    private val ctx = context
    private var themeList : MutableList<Theme> = themes
    private val recyclerViewClickListener : RecyclerViewClickInterface = recyclerListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val inflatedView = parent.inflate(R.layout.list_row_theme, false)
        return ThemeViewHolder(ctx, inflatedView, recyclerViewClickListener)
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.themeView.setTheme(themeList[position])
        holder.themeView.isActivated = ThemesActivity.selectedTheme == position
    }

    override fun getItemCount(): Int {
        return themeList.size
    }

    class ThemeViewHolder(context: Context, v: View, private val listener: RecyclerViewClickInterface) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private val ctx = context
        private var view = v
        var themeView: ThemeView = view.findViewById(R.id.theme_row)

        init {
            themeView.setOnClickListener(this)
        }

        override fun onClick(vw: View) {
            listener.onClick(vw, adapterPosition)
            ThemesActivity.selectedTheme = adapterPosition
//            ThemesActivity.themeId = ThemesActivity.themeList[adapterPosition].id
            PreferenceManager.getDefaultSharedPreferences(ctx).edit().putInt("THEME_ID", ThemesActivity.themeList[adapterPosition].id).commit()
            themeView.isActivated = true
//            this@ThemeAdapter.notifyDataSetChanged()
        }
    }

}
