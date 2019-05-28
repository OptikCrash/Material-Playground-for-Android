package com.digitalrelay.materialplayground.views

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat
import com.digitalrelay.materialplayground.R
import com.digitalrelay.materialplayground.models.Theme


class ThemeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private val ctx: Context = context
    private var theme = Theme(R.color.primaryColorWDFW, R.color.primaryDarkColorWDFW, R.color.secondaryColorWDFW)

    private var boarderPaint: Paint? = null
    private var primaryPaint: Paint? = null
    private var primaryDarkPaint: Paint? = null
    private var accentPaint: Paint? = null
    private var backgroundPaint: Paint? = null

    private var stroke: Float = 0.toFloat()

    init {
        try {
            boarderPaint = Paint()
            boarderPaint?.style = Paint.Style.STROKE
            if (this.isSelected) boarderPaint?.color = Color.BLUE
            else boarderPaint?.color = Color.GRAY

            backgroundPaint = Paint()
            backgroundPaint?.style = Paint.Style.FILL
            val a = TypedValue()
            ctx.theme.resolveAttribute(android.R.attr.windowBackground, a, true)
            if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT)
                backgroundPaint?.color = ContextCompat.getColor(ctx, android.R.color.background_light)
            else backgroundPaint?.color = ContextCompat.getColor(ctx, a.data)

            primaryDarkPaint = Paint()
            primaryDarkPaint?.style = Paint.Style.FILL
            primaryDarkPaint?.color = ContextCompat.getColor(ctx, theme.primaryDarkColor)

            primaryPaint = Paint()
            primaryPaint?.style = Paint.Style.FILL
            primaryPaint?.color = ContextCompat.getColor(ctx, theme.primaryColor)

            accentPaint = Paint()
            accentPaint?.style = Paint.Style.FILL
            accentPaint?.color = ContextCompat.getColor(ctx, theme.accentColor)
            accentPaint?.isAntiAlias = true
            accentPaint?.isDither = true
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun setTheme(thm: Theme) {
        this.theme = thm
        initialize()
        invalidate()

    }

    private fun initialize() {
        try {
            boarderPaint = Paint()
            boarderPaint?.style = Paint.Style.STROKE
            if (this.isSelected) boarderPaint?.color = Color.BLUE
            else boarderPaint?.color = Color.GRAY

            backgroundPaint = Paint()
            backgroundPaint?.style = Paint.Style.FILL
            val a = TypedValue()
            ctx.theme.resolveAttribute(android.R.attr.windowBackground, a, true)
            if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT)
                backgroundPaint?.color = ContextCompat.getColor(ctx, android.R.color.background_light)
            else backgroundPaint?.color = ContextCompat.getColor(ctx, a.data)

            primaryDarkPaint = Paint()
            primaryDarkPaint?.style = Paint.Style.FILL
            primaryDarkPaint?.color = ContextCompat.getColor(ctx, theme.primaryDarkColor)

            primaryPaint = Paint()
            primaryPaint?.style = Paint.Style.FILL
            primaryPaint?.color = ContextCompat.getColor(ctx, theme.primaryColor)

            accentPaint = Paint()
            accentPaint?.style = Paint.Style.FILL
            accentPaint?.color = ContextCompat.getColor(ctx, theme.accentColor)
            accentPaint?.isAntiAlias = true
            accentPaint?.isDither = true
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val height = height.toFloat()
        val width = width.toFloat()
        stroke = height * 8 / 100f
        val statusbar = height * 16 / 100f
        val toolbar = height * 72 / 100f

        if (this.isActivated) {
            boarderPaint?.color = ContextCompat.getColor(context, R.color.themeSelected)
        } else {
            boarderPaint?.color = ContextCompat.getColor(context, R.color.themeDeselected)
        }
        boarderPaint!!.setStrokeWidth(stroke)
        canvas.drawRect(0f, 0f, width, height, backgroundPaint!!)
        canvas.drawRect(0f, 0f, width, statusbar, primaryDarkPaint!!)
        canvas.drawRect(0f, statusbar, width, toolbar, primaryPaint!!)
        canvas.drawCircle(width - stroke - height * 20 / 100f, toolbar, height * 16 / 100, accentPaint!!)
        canvas.drawRect(0f, 0f, width, height, boarderPaint!!)
    }
}