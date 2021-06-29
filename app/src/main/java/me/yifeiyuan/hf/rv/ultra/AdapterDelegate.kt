package me.yifeiyuan.hf.rv.ultra

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
interface AdapterDelegate<T,VH :Component> {

    companion object {
        private const val TAG = "IAdapterDelegate"
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    fun onBindViewHolder(
        holder: VH,
        position: Int,
        payloads: MutableList<Any>,
        model: T?,
        adapter: ComponentAdapter
    ) {
        holder.bind(model, position, payloads, adapter)
    }

    fun onViewRecycled(component: VH, adapter: ComponentAdapter){
        component.onViewRecycled(adapter)
    }

    fun getItemId(model: Any, position: Int): Long = RecyclerView.NO_ID

    fun getItemViewType(model: Any, position: Int): Int

    fun onViewAttachedToWindow(component: VH, adapter: ComponentAdapter) {
        component.onViewAttachedToWindow(adapter)
    }

    fun onViewDetachedFromWindow(component: VH, adapter: ComponentAdapter) {
        component.onViewDetachedFromWindow(adapter)
    }

    fun onFailedToRecycleView(component: VH, adapter: ComponentAdapter): Boolean {
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