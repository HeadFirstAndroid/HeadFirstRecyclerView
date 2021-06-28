package me.yifeiyuan.hf.rv.ultra

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
interface AdapterDelegate {

    companion object {
        private const val TAG = "IAdapterDelegate"
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component

    fun onBindViewHolder(
        holder: Component,
        position: Int,
        payloads: MutableList<Any>,
        model: Any?,
        adapter: ComponentAdapter
    ) {
        holder.bind(model, position, payloads, adapter)
    }

    fun onViewRecycled(component: Component, adapter: ComponentAdapter){
        component.onViewRecycled(adapter)
    }

    fun getItemId(model: Any, position: Int): Long = RecyclerView.NO_ID

    fun getItemViewType(model: Any, position: Int): Int

    fun onViewAttachedToWindow(component: Component, adapter: ComponentAdapter) {
        component.onViewAttachedToWindow(adapter)
    }

    fun onViewDetachedFromWindow(component: Component, adapter: ComponentAdapter) {
        component.onViewDetachedFromWindow(adapter)
    }

    fun onFailedToRecycleView(component: Component, adapter: ComponentAdapter): Boolean {
        return component.onFailedToRecycleView(adapter)
    }

    fun onDetachedFromRecyclerView(recyclerView: RecyclerView, componentAdapter: ComponentAdapter) {
        Log.d(
            TAG,
            "onDetachedFromRecyclerView() called with: recyclerView = $recyclerView, componentAdapter = $componentAdapter"
        )
    }

    fun onAttachedToRecyclerView(recyclerView: RecyclerView, componentAdapter: ComponentAdapter) {
        Log.d(
            TAG,
            "onAttachedToRecyclerView() called with: recyclerView = $recyclerView, componentAdapter = $componentAdapter"
        )
    }
}