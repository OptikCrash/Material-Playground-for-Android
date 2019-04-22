package com.digitalrelay.materialplayground.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetHidesAppBarBehavior(context: Context, attrs: AttributeSet) : AppBarLayout.ScrollingViewBehavior() {
    private val UNDEFINED: Float = Float.MAX_VALUE
    private var childStartY = UNDEFINED

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return getBottomSheetBehavior(dependency) != null
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        val bottomSheetBehavior = getBottomSheetBehavior(dependency)
        if (bottomSheetBehavior != null) {
            val slideOffset = getSlideOffset(parent, dependency, bottomSheetBehavior)

            child.alpha = (1 - slideOffset)

            if (childStartY == UNDEFINED) {
                childStartY = child.y
            }

            val childHeight = child.measuredHeight
            val childY = childStartY - childHeight * slideOffset
            child.y = childY
        }
        return true
    }

    private fun getSlideOffset(parent: CoordinatorLayout, dependency: View, bottomSheetBehavior: BottomSheetBehavior<*>): Float {
        val parentHeight = parent.measuredHeight
        val sheetY = dependency.y
        val peekHeight = bottomSheetBehavior.peekHeight
        val sheetHeight = dependency.height
        val collapseY = (parentHeight - peekHeight).toFloat()
        val expandY = (parentHeight - sheetHeight).toFloat()
        val deltaY = collapseY - expandY

        return (parentHeight.toFloat() - peekHeight.toFloat() - sheetY) / deltaY
    }

    private fun getBottomSheetBehavior(view: View): BottomSheetBehavior<*>? {
        val params = view.layoutParams as CoordinatorLayout.LayoutParams
        return params.behavior as? BottomSheetBehavior<*>
    }

}