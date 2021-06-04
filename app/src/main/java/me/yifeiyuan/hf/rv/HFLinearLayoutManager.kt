package me.yifeiyuan.hf.rv

import android.content.Context
import android.graphics.PointF
import android.graphics.Rect
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class HFLinearLayoutManager(
    context: Context,
    attrs: AttributeSet?=null,
    defStyleAttr: Int=0,
    defStyleRes: Int=0
) : LinearLayoutManager(context, attrs, defStyleAttr, defStyleRes) {

    companion object{
        private const val TAG = "HFLinearLayoutManager"
    }

    override fun setMeasuredDimension(childrenBounds: Rect?, wSpec: Int, hSpec: Int) {
        Log.d(
            TAG,
            "setMeasuredDimension() called with: childrenBounds = $childrenBounds, wSpec = $wSpec, hSpec = $hSpec"
        )
        super.setMeasuredDimension(childrenBounds, wSpec, hSpec)
    }

    override fun setMeasuredDimension(widthSize: Int, heightSize: Int) {
        Log.d(
            TAG,
            "setMeasuredDimension() called with: widthSize = $widthSize, heightSize = $heightSize"
        )
        super.setMeasuredDimension(widthSize, heightSize)
    }

    override fun requestLayout() {
        Log.d(TAG, "requestLayout() called")
        super.requestLayout()
    }

    override fun assertInLayoutOrScroll(message: String?) {
        Log.d(TAG, "assertInLayoutOrScroll() called with: message = $message")
        super.assertInLayoutOrScroll(message)
    }

    override fun assertNotInLayoutOrScroll(message: String?) {
        Log.d(TAG, "assertNotInLayoutOrScroll() called with: message = $message")
        super.assertNotInLayoutOrScroll(message)
    }

    override fun setAutoMeasureEnabled(enabled: Boolean) {
        Log.d(TAG, "setAutoMeasureEnabled() called with: enabled = $enabled")
        super.setAutoMeasureEnabled(enabled)
    }

    override fun isAutoMeasureEnabled(): Boolean {
        Log.d(TAG, "isAutoMeasureEnabled() called")
        return super.isAutoMeasureEnabled()
    }

    override fun supportsPredictiveItemAnimations(): Boolean {
        Log.d(TAG, "supportsPredictiveItemAnimations() called")
        return super.supportsPredictiveItemAnimations()
    }

    override fun collectAdjacentPrefetchPositions(
        dx: Int,
        dy: Int,
        state: RecyclerView.State?,
        layoutPrefetchRegistry: LayoutPrefetchRegistry?
    ) {
        Log.d(
            TAG,
            "collectAdjacentPrefetchPositions() called with: dx = $dx, dy = $dy, state = $state, layoutPrefetchRegistry = $layoutPrefetchRegistry"
        )
        super.collectAdjacentPrefetchPositions(dx, dy, state, layoutPrefetchRegistry)
    }

    override fun collectInitialPrefetchPositions(
        adapterItemCount: Int,
        layoutPrefetchRegistry: LayoutPrefetchRegistry?
    ) {
        Log.d(
            TAG,
            "collectInitialPrefetchPositions() called with: adapterItemCount = $adapterItemCount, layoutPrefetchRegistry = $layoutPrefetchRegistry"
        )
        super.collectInitialPrefetchPositions(adapterItemCount, layoutPrefetchRegistry)
    }

    override fun isAttachedToWindow(): Boolean {
        Log.d(TAG, "isAttachedToWindow() called ${super.isAttachedToWindow()}")
        return super.isAttachedToWindow()
    }

    override fun postOnAnimation(action: Runnable?) {
        Log.d(TAG, "postOnAnimation() called with: action = $action")
        super.postOnAnimation(action)
    }

    override fun removeCallbacks(action: Runnable?): Boolean {
        Log.d(TAG, "removeCallbacks() called with: action = $action")
        return super.removeCallbacks(action)
    }

    override fun onAttachedToWindow(view: RecyclerView?) {
        Log.d(TAG, "onAttachedToWindow() called with: view = $view")
        super.onAttachedToWindow(view)
    }

    override fun onDetachedFromWindow(view: RecyclerView?, recycler: RecyclerView.Recycler?) {
        Log.d(TAG, "onDetachedFromWindow() called with: view = $view, recycler = $recycler")
        super.onDetachedFromWindow(view, recycler)
    }

    override fun onDetachedFromWindow(view: RecyclerView?) {
        Log.d(TAG, "onDetachedFromWindow() called with: view = $view")
        super.onDetachedFromWindow(view)
    }

    override fun getClipToPadding(): Boolean {
        Log.d(TAG, "getClipToPadding() called")
        return super.getClipToPadding()
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        Log.d(TAG, "onLayoutChildren() called with: recycler = $recycler, state = $state")
        super.onLayoutChildren(recycler, state)
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        Log.d(TAG, "onLayoutCompleted() called with: state = $state")
        super.onLayoutCompleted(state)
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        Log.d(TAG, "generateDefaultLayoutParams() called")
        return super.generateDefaultLayoutParams()
    }

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
        Log.d(TAG, "checkLayoutParams() called with: lp = $lp")
        return super.checkLayoutParams(lp)
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams?): RecyclerView.LayoutParams {
        Log.d(TAG, "generateLayoutParams() called with: lp = $lp")
        return super.generateLayoutParams(lp)
    }

    override fun generateLayoutParams(
        c: Context?,
        attrs: AttributeSet?
    ): RecyclerView.LayoutParams {
        Log.d(TAG, "generateLayoutParams() called with: c = $c, attrs = $attrs")
        return super.generateLayoutParams(c, attrs)
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        Log.d(
            TAG,
            "scrollHorizontallyBy() called with: dx = $dx, recycler = $recycler, state = $state"
        )
        return super.scrollHorizontallyBy(dx, recycler, state)
    }

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        Log.d(
            TAG,
            "scrollVerticallyBy() called with: dy = $dy, recycler = $recycler, state = $state"
        )
        return super.scrollVerticallyBy(dy, recycler, state)
    }

    override fun canScrollHorizontally(): Boolean {
        Log.d(TAG, "canScrollHorizontally() called")
        return super.canScrollHorizontally()
    }

    override fun canScrollVertically(): Boolean {
        Log.d(TAG, "canScrollVertically() called")
        return super.canScrollVertically()
    }

    override fun scrollToPosition(position: Int) {
        Log.d(TAG, "scrollToPosition() called with: position = $position")
        super.scrollToPosition(position)
    }

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView?,
        state: RecyclerView.State?,
        position: Int
    ) {
        Log.d(
            TAG,
            "smoothScrollToPosition() called with: recyclerView = $recyclerView, state = $state, position = $position"
        )
        super.smoothScrollToPosition(recyclerView, state, position)
    }

    override fun startSmoothScroll(smoothScroller: RecyclerView.SmoothScroller?) {
        Log.d(TAG, "startSmoothScroll() called with: smoothScroller = $smoothScroller")
        super.startSmoothScroll(smoothScroller)
    }

    override fun isSmoothScrolling(): Boolean {
        Log.d(TAG, "isSmoothScrolling() called")
        return super.isSmoothScrolling()
    }

    override fun getLayoutDirection(): Int {
        Log.d(TAG, "getLayoutDirection() called")
        return super.getLayoutDirection()
    }

    override fun endAnimation(view: View?) {
        Log.d(TAG, "endAnimation() called with: view = $view")
        super.endAnimation(view)
    }

    override fun addDisappearingView(child: View?) {
        Log.d(TAG, "addDisappearingView() called with: child = $child")
        super.addDisappearingView(child)
    }

    override fun addDisappearingView(child: View?, index: Int) {
        Log.d(TAG, "addDisappearingView() called with: child = $child, index = $index")
        super.addDisappearingView(child, index)
    }

    override fun addView(child: View?) {
        Log.d(TAG, "addView() called with: child = $child")
        super.addView(child)
    }

    override fun addView(child: View?, index: Int) {
        Log.d(TAG, "addView() called with: child = $child, index = $index")
        super.addView(child, index)
    }

    override fun removeView(child: View?) {
        Log.d(TAG, "removeView() called with: child = $child")
        super.removeView(child)
    }

    override fun removeViewAt(index: Int) {
        Log.d(TAG, "removeViewAt() called with: index = $index")
        super.removeViewAt(index)
    }

    override fun removeAllViews() {
        super.removeAllViews()
    }

    override fun getBaseline(): Int {
        return super.getBaseline()
    }

    override fun getPosition(view: View): Int {
        return super.getPosition(view)
    }

    override fun getItemViewType(view: View): Int {
        Log.d(TAG, "getItemViewType() called with: view = $view")
        return super.getItemViewType(view)
    }

    override fun findContainingItemView(view: View): View? {
        Log.d(TAG, "findContainingItemView() called with: view = $view")
        return super.findContainingItemView(view)
    }

    override fun findViewByPosition(position: Int): View? {
        Log.d(TAG, "findViewByPosition() called with: position = $position")
        return super.findViewByPosition(position)
    }

    override fun detachView(child: View) {
        Log.d(TAG, "detachView() called with: child = $child")
        super.detachView(child)
    }

    override fun detachViewAt(index: Int) {
        Log.d(TAG, "detachViewAt() called with: index = $index")
        super.detachViewAt(index)
    }

    override fun attachView(child: View, index: Int, lp: RecyclerView.LayoutParams?) {
        Log.d(TAG, "attachView() called with: child = $child, index = $index, lp = $lp")
        super.attachView(child, index, lp)
    }

    override fun attachView(child: View, index: Int) {
        Log.d(TAG, "attachView() called with: child = $child, index = $index")
        super.attachView(child, index)
    }

    override fun attachView(child: View) {
        Log.d(TAG, "attachView() called with: child = $child")
        super.attachView(child)
    }

    override fun removeDetachedView(child: View) {
        Log.d(TAG, "removeDetachedView() called with: child = $child")
        super.removeDetachedView(child)
    }

    override fun moveView(fromIndex: Int, toIndex: Int) {
        Log.d(TAG, "moveView() called with: fromIndex = $fromIndex, toIndex = $toIndex")
        super.moveView(fromIndex, toIndex)
    }

    override fun detachAndScrapView(child: View, recycler: RecyclerView.Recycler) {
        Log.d(TAG, "detachAndScrapView() called with: child = $child, recycler = $recycler")
        super.detachAndScrapView(child, recycler)
    }

    override fun detachAndScrapViewAt(index: Int, recycler: RecyclerView.Recycler) {
        Log.d(TAG, "detachAndScrapViewAt() called with: index = $index, recycler = $recycler")
        super.detachAndScrapViewAt(index, recycler)
    }

    override fun removeAndRecycleView(child: View, recycler: RecyclerView.Recycler) {
        Log.d(TAG, "removeAndRecycleView() called with: child = $child, recycler = $recycler")
        super.removeAndRecycleView(child, recycler)
    }

    override fun removeAndRecycleViewAt(index: Int, recycler: RecyclerView.Recycler) {
        Log.d(TAG, "removeAndRecycleViewAt() called with: index = $index, recycler = $recycler")
        super.removeAndRecycleViewAt(index, recycler)
    }

    override fun getChildCount(): Int {
        return super.getChildCount()
    }

    override fun getChildAt(index: Int): View? {
        return super.getChildAt(index)
    }

    override fun getWidthMode(): Int {
        return super.getWidthMode()
    }

    override fun getHeightMode(): Int {
        return super.getHeightMode()
    }

    override fun isFocused(): Boolean {
        return super.isFocused()
    }

    override fun hasFocus(): Boolean {
        return super.hasFocus()
    }

    override fun getFocusedChild(): View? {
        return super.getFocusedChild()
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount() called")
        return super.getItemCount()
    }

    override fun offsetChildrenHorizontal(dx: Int) {
        super.offsetChildrenHorizontal(dx)
    }

    override fun offsetChildrenVertical(dy: Int) {
        super.offsetChildrenVertical(dy)
    }

    override fun ignoreView(view: View) {
        super.ignoreView(view)
    }

    override fun stopIgnoringView(view: View) {
        super.stopIgnoringView(view)
    }

    override fun detachAndScrapAttachedViews(recycler: RecyclerView.Recycler) {
        super.detachAndScrapAttachedViews(recycler)
    }


    override fun measureChild(child: View, widthUsed: Int, heightUsed: Int) {
        super.measureChild(child, widthUsed, heightUsed)
    }

    override fun isMeasurementCacheEnabled(): Boolean {
        return super.isMeasurementCacheEnabled()
    }

    override fun setMeasurementCacheEnabled(measurementCacheEnabled: Boolean) {
        super.setMeasurementCacheEnabled(measurementCacheEnabled)
    }

    override fun measureChildWithMargins(child: View, widthUsed: Int, heightUsed: Int) {
        super.measureChildWithMargins(child, widthUsed, heightUsed)
    }

    override fun getDecoratedMeasuredWidth(child: View): Int {
        return super.getDecoratedMeasuredWidth(child)
    }

    override fun getDecoratedMeasuredHeight(child: View): Int {
        return super.getDecoratedMeasuredHeight(child)
    }

    override fun layoutDecorated(child: View, left: Int, top: Int, right: Int, bottom: Int) {
        super.layoutDecorated(child, left, top, right, bottom)
    }

    override fun layoutDecoratedWithMargins(
        child: View,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        super.layoutDecoratedWithMargins(child, left, top, right, bottom)
    }

    override fun getTransformedBoundingBox(child: View, includeDecorInsets: Boolean, out: Rect) {
        super.getTransformedBoundingBox(child, includeDecorInsets, out)
    }

    override fun getDecoratedBoundsWithMargins(view: View, outBounds: Rect) {
        super.getDecoratedBoundsWithMargins(view, outBounds)
    }

    override fun getDecoratedLeft(child: View): Int {
        return super.getDecoratedLeft(child)
    }

    override fun getDecoratedTop(child: View): Int {
        return super.getDecoratedTop(child)
    }

    override fun getDecoratedRight(child: View): Int {
        return super.getDecoratedRight(child)
    }

    override fun getDecoratedBottom(child: View): Int {
        return super.getDecoratedBottom(child)
    }

    override fun calculateItemDecorationsForChild(child: View, outRect: Rect) {
        super.calculateItemDecorationsForChild(child, outRect)
    }

    override fun getTopDecorationHeight(child: View): Int {
        return super.getTopDecorationHeight(child)
    }

    override fun getBottomDecorationHeight(child: View): Int {
        return super.getBottomDecorationHeight(child)
    }

    override fun getLeftDecorationWidth(child: View): Int {
        return super.getLeftDecorationWidth(child)
    }

    override fun getRightDecorationWidth(child: View): Int {
        return super.getRightDecorationWidth(child)
    }

    override fun onFocusSearchFailed(
        focused: View,
        focusDirection: Int,
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): View? {
        return super.onFocusSearchFailed(focused, focusDirection, recycler, state)
    }

    override fun onInterceptFocusSearch(focused: View, direction: Int): View? {
        return super.onInterceptFocusSearch(focused, direction)
    }

    override fun requestChildRectangleOnScreen(
        parent: RecyclerView,
        child: View,
        rect: Rect,
        immediate: Boolean
    ): Boolean {
        return super.requestChildRectangleOnScreen(parent, child, rect, immediate)
    }

    override fun requestChildRectangleOnScreen(
        parent: RecyclerView,
        child: View,
        rect: Rect,
        immediate: Boolean,
        focusedChildVisible: Boolean
    ): Boolean {
        return super.requestChildRectangleOnScreen(
            parent,
            child,
            rect,
            immediate,
            focusedChildVisible
        )
    }

    override fun isViewPartiallyVisible(
        child: View,
        completelyVisible: Boolean,
        acceptEndPointInclusion: Boolean
    ): Boolean {
        Log.d(
            TAG,
            "isViewPartiallyVisible() called with: child = $child, completelyVisible = $completelyVisible, acceptEndPointInclusion = $acceptEndPointInclusion"
        )
        return super.isViewPartiallyVisible(child, completelyVisible, acceptEndPointInclusion)
    }

    override fun onRequestChildFocus(parent: RecyclerView, child: View, focused: View?): Boolean {
        return super.onRequestChildFocus(parent, child, focused)
    }

    override fun onRequestChildFocus(
        parent: RecyclerView,
        state: RecyclerView.State,
        child: View,
        focused: View?
    ): Boolean {
        return super.onRequestChildFocus(parent, state, child, focused)
    }

    override fun onAdapterChanged(
        oldAdapter: RecyclerView.Adapter<*>?,
        newAdapter: RecyclerView.Adapter<*>?
    ) {
        Log.d(
            TAG,
            "onAdapterChanged() called with: oldAdapter = $oldAdapter, newAdapter = $newAdapter"
        )
        super.onAdapterChanged(oldAdapter, newAdapter)
    }

    override fun onAddFocusables(
        recyclerView: RecyclerView,
        views: ArrayList<View>,
        direction: Int,
        focusableMode: Int
    ): Boolean {
        return super.onAddFocusables(recyclerView, views, direction, focusableMode)
    }

    override fun onItemsChanged(recyclerView: RecyclerView) {
        Log.d(TAG, "onItemsChanged() called with: recyclerView = $recyclerView")
        super.onItemsChanged(recyclerView)
    }

    override fun onItemsAdded(recyclerView: RecyclerView, positionStart: Int, itemCount: Int) {
        Log.d(
            TAG,
            "onItemsAdded() called with: recyclerView = $recyclerView, positionStart = $positionStart, itemCount = $itemCount"
        )
        super.onItemsAdded(recyclerView, positionStart, itemCount)
    }

    override fun onItemsRemoved(recyclerView: RecyclerView, positionStart: Int, itemCount: Int) {
        Log.d(
            TAG,
            "onItemsRemoved() called with: recyclerView = $recyclerView, positionStart = $positionStart, itemCount = $itemCount"
        )
        super.onItemsRemoved(recyclerView, positionStart, itemCount)
    }

    override fun onItemsUpdated(recyclerView: RecyclerView, positionStart: Int, itemCount: Int) {
        Log.d(
            TAG,
            "onItemsUpdated() called with: recyclerView = $recyclerView, positionStart = $positionStart, itemCount = $itemCount"
        )
        super.onItemsUpdated(recyclerView, positionStart, itemCount)
    }

    override fun onItemsUpdated(
        recyclerView: RecyclerView,
        positionStart: Int,
        itemCount: Int,
        payload: Any?
    ) {
        Log.d(
            TAG,
            "onItemsUpdated() called with: recyclerView = $recyclerView, positionStart = $positionStart, itemCount = $itemCount, payload = $payload"
        )
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload)
    }

    override fun onItemsMoved(recyclerView: RecyclerView, from: Int, to: Int, itemCount: Int) {
        Log.d(
            TAG,
            "onItemsMoved() called with: recyclerView = $recyclerView, from = $from, to = $to, itemCount = $itemCount"
        )
        super.onItemsMoved(recyclerView, from, to, itemCount)
    }

    override fun computeHorizontalScrollExtent(state: RecyclerView.State): Int {
        return super.computeHorizontalScrollExtent(state)
    }

    override fun computeHorizontalScrollOffset(state: RecyclerView.State): Int {
        return super.computeHorizontalScrollOffset(state)
    }

    override fun computeHorizontalScrollRange(state: RecyclerView.State): Int {
        return super.computeHorizontalScrollRange(state)
    }

    override fun computeVerticalScrollExtent(state: RecyclerView.State): Int {
        return super.computeVerticalScrollExtent(state)
    }

    override fun computeVerticalScrollOffset(state: RecyclerView.State): Int {
        return super.computeVerticalScrollOffset(state)
    }

    override fun computeVerticalScrollRange(state: RecyclerView.State): Int {
        return super.computeVerticalScrollRange(state)
    }

    override fun onMeasure(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        widthSpec: Int,
        heightSpec: Int
    ) {
        super.onMeasure(recycler, state, widthSpec, heightSpec)
    }

    override fun getMinimumWidth(): Int {
        return super.getMinimumWidth()
    }

    override fun getMinimumHeight(): Int {
        return super.getMinimumHeight()
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
    }

    override fun removeAndRecycleAllViews(recycler: RecyclerView.Recycler) {
        Log.d(TAG, "removeAndRecycleAllViews() called with: recycler = $recycler")
        super.removeAndRecycleAllViews(recycler)
    }

    override fun onInitializeAccessibilityNodeInfo(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        info: AccessibilityNodeInfoCompat
    ) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, info)
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent) {
        super.onInitializeAccessibilityEvent(event)
    }

    override fun onInitializeAccessibilityEvent(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        event: AccessibilityEvent
    ) {
        super.onInitializeAccessibilityEvent(recycler, state, event)
    }

    override fun onInitializeAccessibilityNodeInfoForItem(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        host: View,
        info: AccessibilityNodeInfoCompat
    ) {
        super.onInitializeAccessibilityNodeInfoForItem(recycler, state, host, info)
    }

    override fun requestSimpleAnimationsInNextLayout() {
        Log.d(TAG, "requestSimpleAnimationsInNextLayout() called")
        super.requestSimpleAnimationsInNextLayout()
    }

    override fun getSelectionModeForAccessibility(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int {
        return super.getSelectionModeForAccessibility(recycler, state)
    }

    override fun getRowCountForAccessibility(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int {
        return super.getRowCountForAccessibility(recycler, state)
    }

    override fun getColumnCountForAccessibility(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int {
        return super.getColumnCountForAccessibility(recycler, state)
    }

    override fun isLayoutHierarchical(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Boolean {
        return super.isLayoutHierarchical(recycler, state)
    }

    override fun performAccessibilityAction(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        action: Int,
        args: Bundle?
    ): Boolean {
        return super.performAccessibilityAction(recycler, state, action, args)
    }

    override fun performAccessibilityActionForItem(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        view: View,
        action: Int,
        args: Bundle?
    ): Boolean {
        return super.performAccessibilityActionForItem(recycler, state, view, action, args)
    }

    override fun prepareForDrop(view: View, target: View, x: Int, y: Int) {
        Log.d(TAG, "prepareForDrop() called with: view = $view, target = $target, x = $x, y = $y")
        super.prepareForDrop(view, target, x, y)
    }

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
        Log.d(TAG, "computeScrollVectorForPosition() called with: targetPosition = $targetPosition")
        return super.computeScrollVectorForPosition(targetPosition)
    }

    override fun getRecycleChildrenOnDetach(): Boolean {
        Log.d(TAG, "getRecycleChildrenOnDetach() called")
        return super.getRecycleChildrenOnDetach()
    }

    override fun setRecycleChildrenOnDetach(recycleChildrenOnDetach: Boolean) {
        Log.d(
            TAG,
            "setRecycleChildrenOnDetach() called with: recycleChildrenOnDetach = $recycleChildrenOnDetach"
        )
        super.setRecycleChildrenOnDetach(recycleChildrenOnDetach)
    }

    override fun setStackFromEnd(stackFromEnd: Boolean) {
        super.setStackFromEnd(stackFromEnd)
    }

    override fun getStackFromEnd(): Boolean {
        return super.getStackFromEnd()
    }

    override fun getOrientation(): Int {
        return super.getOrientation()
    }

    override fun setOrientation(orientation: Int) {
        super.setOrientation(orientation)
    }

    override fun getReverseLayout(): Boolean {
        return super.getReverseLayout()
    }

    override fun setReverseLayout(reverseLayout: Boolean) {
        super.setReverseLayout(reverseLayout)
    }

    override fun getExtraLayoutSpace(state: RecyclerView.State?): Int {
        Log.d(TAG, "getExtraLayoutSpace() called with: state = $state")
        return super.getExtraLayoutSpace(state)
    }

    override fun calculateExtraLayoutSpace(state: RecyclerView.State, extraLayoutSpace: IntArray) {
        Log.d(
            TAG,
            "calculateExtraLayoutSpace() called with: state = $state, extraLayoutSpace = $extraLayoutSpace"
        )
        super.calculateExtraLayoutSpace(state, extraLayoutSpace)
    }

    override fun isLayoutRTL(): Boolean {
        return super.isLayoutRTL()
    }

    override fun scrollToPositionWithOffset(position: Int, offset: Int) {
        super.scrollToPositionWithOffset(position, offset)
    }

    override fun setSmoothScrollbarEnabled(enabled: Boolean) {
        super.setSmoothScrollbarEnabled(enabled)
    }

    override fun isSmoothScrollbarEnabled(): Boolean {
        return super.isSmoothScrollbarEnabled()
    }

    override fun setInitialPrefetchItemCount(itemCount: Int) {
        Log.d(TAG, "setInitialPrefetchItemCount() called with: itemCount = $itemCount")
        super.setInitialPrefetchItemCount(itemCount)
    }

    override fun getInitialPrefetchItemCount(): Int {
        Log.d(TAG, "getInitialPrefetchItemCount() called ${super.getInitialPrefetchItemCount()}")
        return super.getInitialPrefetchItemCount()
    }

    override fun findFirstVisibleItemPosition(): Int {
        return super.findFirstVisibleItemPosition()
    }

    override fun findFirstCompletelyVisibleItemPosition(): Int {
        return super.findFirstCompletelyVisibleItemPosition()
    }

    override fun findLastVisibleItemPosition(): Int {
        return super.findLastVisibleItemPosition()
    }

    override fun findLastCompletelyVisibleItemPosition(): Int {
        return super.findLastCompletelyVisibleItemPosition()
    }
}