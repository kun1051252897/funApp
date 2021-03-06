package com.example.funapp.view.itemdecoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

class LinearItemDecoration(
    private var drawHeader: Boolean = true,//第一项底部是否画线，默认画
    private var drawFooter: Boolean = true,//最后一项顶部是否画线，默认画
    private var drawMargin: Boolean = false,//绘制margin区域的颜色
    @Px private var marginLeft: Int = 0,
    @Px private var marginRight: Int = 0,
    @Px private var dividerSize: Int = 2,//横线分割线宽度，默认2px
    private var marginLeftColor: Int = Color.parseColor("#ffffff"),
    private var marginRightColor: Int = Color.parseColor("#ffffff"),
    private var dividerColor: Int = Color.parseColor("#000000")//分割线颜色
) : RecyclerView.ItemDecoration() {

    private val paint: Paint by lazy {
        Paint().apply {
            color = dividerColor
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }
    private val marginStartPaint: Paint by lazy {
        Paint().apply {
            color = marginLeftColor
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }
    private val marginEndPaint: Paint by lazy {
        Paint().apply {
            color = marginRightColor
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.adapter?.let {
            val childCount = parent.childCount
            val itemCount = it.itemCount
            for (i in 0 until childCount) {
                val childView = parent.getChildAt(i)
                val itemPosition = parent.getChildLayoutPosition(childView)
                if (itemPosition == 0 && !drawHeader)
                    continue
                if (itemPosition == itemCount - 1)
                    continue
                if (itemPosition == itemCount - 2 && !drawFooter)
                    continue
                val left = (childView.left + marginLeft).toFloat()
                val top = childView.bottom.toFloat()
                val right = (childView.right - marginRight).toFloat()
                val bottom = (top + dividerSize)
                c.drawRect(left, top, right, bottom, paint)
                if (drawMargin) {
                    c.drawRect(childView.left.toFloat(), top, left, bottom, marginStartPaint)
                    c.drawRect(childView.right.toFloat(), top, right, bottom, marginEndPaint)
                }
            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let {
            val position = parent.getChildLayoutPosition(view)
            val childCount = it.itemCount
            if ((position == 0 && !drawHeader) || position == childCount - 1 ||
                (position == childCount - 2 && !drawFooter)
            ) {
                return
            }
            outRect.set(0, 0, 0, dividerSize)
        }
    }
}