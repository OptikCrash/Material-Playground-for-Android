package com.digitalrelay.materialplayground.views

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import android.view.Gravity
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.ProgressBar
import android.widget.FrameLayout
import com.digitalrelay.materialplayground.R


/**
 * Created by Pankaj on 16-10-2017.
 */
//@CoordinatorLayout.DefaultBehavior(FabProgressLayout.Behavior.class)
class FabProgressLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private var progressBar: ProgressBar? = null
    private var fab: FloatingActionButton? = null

    constructor(context: Context) : this(context, null)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (childCount == 0 || childCount > 2) throw IllegalStateException("Specify only 2 views.")

        for (i in 0 until childCount) {
            when (val view = getChildAt(i)) {
                is ProgressBar -> progressBar = view
                is FloatingActionButton -> fab = view
                else -> throw IllegalStateException("Specify FAB and Progress Bar" + "as view's children in your layout.")
            }
        }

        if (fab == null) throw IllegalStateException("Floating Action Button not specified")
        else if (progressBar == null) throw IllegalStateException("Progress Bar not specified")

        resize()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (fab != null && progressBar != null) resize()
    }

    private fun resize() {
        val translationZpx = resources.displayMetrics.density * 6 // 6 is needed for progress bar to be visible, 5 doesn't work
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) progressBar!!.translationZ = translationZpx

        val fabParams = fab!!.layoutParams as FrameLayout.LayoutParams
        val progressParams = progressBar!!.layoutParams as FrameLayout.LayoutParams

        val additionSize = resources.getDimensionPixelSize(R.dimen.progress_bar_size)
        progressBar!!.layoutParams.height = fab!!.height + additionSize
        progressBar!!.layoutParams.width = fab!!.width + additionSize

        fabParams.gravity = Gravity.CENTER
        progressParams.gravity = Gravity.CENTER
    }

    fun startProgress() {
        if (progressBar != null)
            progressBar!!.visibility = View.VISIBLE
    }

    fun stopProgress() {
        if (progressBar != null)
            progressBar!!.visibility = View.INVISIBLE
    }

    class Behavior(context: Context, attrs: AttributeSet?) : CoordinatorLayout.Behavior<FabProgressLayout>(context, attrs) {

        override fun layoutDependsOn(parent: CoordinatorLayout, child: FabProgressLayout, dependency: View): Boolean {
            return dependency is Snackbar.SnackbarLayout
        }

        override fun onDependentViewChanged(parent: CoordinatorLayout, child: FabProgressLayout, dependency: View): Boolean {
            val translationY = Math.min(0f, dependency.translationY - dependency.height)
            if (child.bottom > dependency.top) child.translationY = translationY
            return true
        }
    }

}