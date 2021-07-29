package me.yifeiyuan.hf.rv.ultra

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
class ComponentAdapter : RecyclerView.Adapter<Component<*>>() {

    companion object {
        private const val TAG = "ComponentAdapter"
    }

    val ultra: Ultra = Ultra

    var data: List<Any>? = null

    private val adapterDelegates: MutableList<AdapterDelegate<*, *>> = mutableListOf()
    private val delegateViewTypeMapper: MutableMap<Int, AdapterDelegate<*, *>?> = mutableMapOf()

    fun registerAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.add(adapterDelegate)
    }

    fun unRegisterAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.remove(adapterDelegate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component<*> {
        val localDelegate = delegateViewTypeMapper[viewType]
        var component: Component<*>? = null
        if (localDelegate != null) {
            component = localDelegate.onCreateViewHolder(parent, viewType)
        }
        if (component == null) {
            component = ultra.onCreateViewHolder(parent, viewType)
        }
        return component
    }

    fun submitData(newData: List<Any>?) {

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: Component<*>, position: Int) {
        holder.bind(getItemData(position), position, mutableListOf(), this)
    }

    override fun onBindViewHolder(holder: Component<*>, position: Int, payloads: MutableList<Any>) {
        holder.bind(getItemData(position), position, payloads, this)
    }

    private fun getItemData(position: Int): Any {
        return data!![position]
    }

    override fun getItemViewType(position: Int): Int {
        var itemViewType = 0
        adapterDelegates.forEach {
            val type = it.getItemViewType(getItemData(position), position)
            if (type > 0) {
                itemViewType = type
                delegateViewTypeMapper[type] = it
                return@forEach
            }
        }

        if (itemViewType <= 0) {
            itemViewType = ultra.getItemViewType(getItemData(position), position)
        }

        return itemViewType
    }

    override fun getItemId(position: Int): Long {
        var itemId = RecyclerView.NO_ID
        adapterDelegates.forEach {
            val id = it.getItemId(getItemData(position), position)
            if (id >= 0) {
                itemId = id
                return@forEach
            }
        }
        if (itemId == RecyclerView.NO_ID) {
            itemId = ultra.getItemId(getItemData(position), position)
        }
        return itemId
    }

    override fun onViewRecycled(holder: Component<*>) {
        holder.onViewRecycled(this)
        Log.d(TAG, "onViewRecycled() called with: holder = $holder")
    }

    override fun onFailedToRecycleView(holder: Component<*>): Boolean {
        Log.d(TAG, "onFailedToRecycleView() called with: holder = $holder")
        return holder.onFailedToRecycleView(this)
    }

    override fun onViewAttachedToWindow(holder: Component<*>) {
        holder.onViewAttachedToWindow(this)
        Log.d(TAG, "onViewAttachedToWindow() called with: holder = $holder")
    }

    override fun onViewDetachedFromWindow(holder: Component<*>) {
        holder.onViewDetachedFromWindow(this)
        Log.d(TAG, "onViewDetachedFromWindow() called with: holder = $holder")
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        Log.d(TAG, "onAttachedToRecyclerView() called with: recyclerView = $recyclerView")
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.d(TAG, "onDetachedFromRecyclerView() called with: recyclerView = $recyclerView")
    }

    override fun findRelativeAdapterPositionIn(
        adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
        viewHolder: RecyclerView.ViewHolder,
        localPosition: Int
    ): Int {
        return super.findRelativeAdapterPositionIn(adapter, viewHolder, localPosition)
    }

    override fun setStateRestorationPolicy(strategy: StateRestorationPolicy) {
        super.setStateRestorationPolicy(strategy)
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    override fun registerAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        super.registerAdapterDataObserver(observer)
    }

    override fun unregisterAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        super.unregisterAdapterDataObserver(observer)
    }
}