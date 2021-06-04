package me.yifeiyuan.hf.rv

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class HFAnimator : DefaultItemAnimator() {

    override fun animateDisappearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo,
        postLayoutInfo: ItemHolderInfo?
    ): Boolean {
        return super.animateDisappearance(viewHolder, preLayoutInfo, postLayoutInfo)
    }

    override fun animateAppearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo?,
        postLayoutInfo: ItemHolderInfo
    ): Boolean {
        return super.animateAppearance(viewHolder, preLayoutInfo, postLayoutInfo)
    }

    override fun animatePersistence(
        viewHolder: RecyclerView.ViewHolder,
        preInfo: ItemHolderInfo,
        postInfo: ItemHolderInfo
    ): Boolean {
        return super.animatePersistence(viewHolder, preInfo, postInfo)
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder?,
        newHolder: RecyclerView.ViewHolder?,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ): Boolean {
        return super.animateChange(oldHolder, newHolder, fromX, fromY, toX, toY)
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder,
        newHolder: RecyclerView.ViewHolder,
        preInfo: ItemHolderInfo,
        postInfo: ItemHolderInfo
    ): Boolean {
        return super.animateChange(oldHolder, newHolder, preInfo, postInfo)
    }

    override fun runPendingAnimations() {
        super.runPendingAnimations()
    }

    override fun endAnimation(item: RecyclerView.ViewHolder) {
        super.endAnimation(item)
    }

    override fun endAnimations() {
        super.endAnimations()
    }

    override fun isRunning(): Boolean {
        return super.isRunning()
    }

    override fun canReuseUpdatedViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ): Boolean {
        return super.canReuseUpdatedViewHolder(viewHolder, payloads)
    }

    override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder): Boolean {
        return super.canReuseUpdatedViewHolder(viewHolder)
    }

    override fun getSupportsChangeAnimations(): Boolean {
        return super.getSupportsChangeAnimations()
    }

    override fun setSupportsChangeAnimations(supportsChangeAnimations: Boolean) {
        super.setSupportsChangeAnimations(supportsChangeAnimations)
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        return super.animateRemove(holder)
    }

    override fun animateAdd(holder: RecyclerView.ViewHolder?): Boolean {
        return super.animateAdd(holder)
    }

    override fun animateMove(
        holder: RecyclerView.ViewHolder?,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ): Boolean {
        return super.animateMove(holder, fromX, fromY, toX, toY)
    }

    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
        super.onRemoveStarting(item)
    }

    override fun onRemoveFinished(item: RecyclerView.ViewHolder?) {
        super.onRemoveFinished(item)
    }

    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        super.onAddStarting(item)
    }

    override fun onAddFinished(item: RecyclerView.ViewHolder?) {
        super.onAddFinished(item)
    }

    override fun onMoveStarting(item: RecyclerView.ViewHolder?) {
        super.onMoveStarting(item)
    }

    override fun onMoveFinished(item: RecyclerView.ViewHolder?) {
        super.onMoveFinished(item)
    }

    override fun onChangeStarting(item: RecyclerView.ViewHolder?, oldItem: Boolean) {
        super.onChangeStarting(item, oldItem)
    }

    override fun onChangeFinished(item: RecyclerView.ViewHolder?, oldItem: Boolean) {
        super.onChangeFinished(item, oldItem)
    }
}