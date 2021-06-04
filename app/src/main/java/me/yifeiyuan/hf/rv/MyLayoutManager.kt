package me.yifeiyuan.hf.rv

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class MyLayoutManager : RecyclerView.LayoutManager() {

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        TODO("Not yet implemented")
    }

    override fun setMeasuredDimension(childrenBounds: Rect?, wSpec: Int, hSpec: Int) {
        super.setMeasuredDimension(childrenBounds, wSpec, hSpec)
    }

    override fun setMeasuredDimension(widthSize: Int, heightSize: Int) {
        super.setMeasuredDimension(widthSize, heightSize)
    }

    override fun requestLayout() {
        super.requestLayout()
    }

    override fun supportsPredictiveItemAnimations(): Boolean {
        return super.supportsPredictiveItemAnimations()
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
    }

    override fun onMeasure(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        widthSpec: Int,
        heightSpec: Int
    ) {
        super.onMeasure(recycler, state, widthSpec, heightSpec)
    }

}