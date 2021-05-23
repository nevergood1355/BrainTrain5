package com.skill_factory.brain_train.views

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.skill_factory.brain_train.R

class HpBarView : View {
    //Drawables
    private val hpBorder = AppCompatResources.getDrawable(context, R.drawable.icon_hp_border)!!
    private val hpFill = AppCompatResources.getDrawable(context, R.drawable.icon_hp)!!

    //Bitmaps
    private lateinit var borderBitmap: Bitmap
    private lateinit var fillBitmap: Bitmap

    private val brush = Paint()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    var value = 3
        set(value) {
            field = value
            invalidate()
        }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        borderBitmap = hpBorder.toBitmap(w / 3, w / 3, Bitmap.Config.ARGB_8888)
        fillBitmap = hpFill.toBitmap(w / 3, w / 3, Bitmap.Config.ARGB_8888)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val margin = 9
        val size = measuredWidth / 3 - margin
        for (i in 0 until 3) {
            val bitmap = if (i < value) {
                fillBitmap
            } else {
                borderBitmap
            }
            canvas.drawBitmap(bitmap, i * (size + margin).toFloat(), 0F, brush)
        }
    }
}