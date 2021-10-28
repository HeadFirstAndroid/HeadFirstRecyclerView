package me.yifeiyuan.hf.rv.ultra

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.NullPointerException

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
open class ComponentAdapter : RecyclerView.Adapter<Component<*>>() {

    companion object {
        private const val TAG = "ComponentAdapter"

        fun registerGlobalAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
            Ultra.registerAdapterDelegate(adapterDelegate)
        }

        fun registerGlobalAdapterHook(adapterHook: AdapterHook) {
            Ultra.registerAdapterHook(adapterHook)
        }
    }

//    val ultra: Ultra = Ultra

    private var data: MutableList<Any> = mutableListOf()

    private var defaultAdapterDelegate: AdapterDelegate<*, *>? = DefaultAdapterDelegate()

    private val adapterDelegates: MutableList<AdapterDelegate<*, *>> = mutableListOf()

    //TODO 将空、异常状态放到 Adapter 真的好吗？
//    private val emptyStatusAdapterDelegate: AdapterDelegate<*, *>? = null
//    private val errorStatusAdapterDelegate: AdapterDelegate<*, *>? = null
//    private var state: UltraRecyclerView.State = UltraRecyclerView.State.Empty

    private val viewTypeDelegateMapper: MutableMap<Int, AdapterDelegate<*, *>?> = mutableMapOf()

    private val hooks: MutableList<AdapterHook> = mutableListOf<AdapterHook>()

    //    TODO 真的需要吗？
//    var onItemClickListener: ((View, Int, Any) -> Unit)? = null
    var onItemClickListener: OnItemClickListener? = null

    private val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
//            checkEmptyStatus()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
//            checkEmptyStatus()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
//            checkEmptyStatus()
        }
    }

    init {
        hooks.addAll(Ultra.hooks)
        adapterDelegates.addAll(Ultra.adapterDelegates)
        registerAdapterDataObserver(dataObserver)
    }

    fun registerAdapterHook(adapterHook: AdapterHook) {
        hooks.add(adapterHook)
    }

    fun unRegisterAdapterHook(adapterHook: AdapterHook) {
        hooks.remove(adapterHook)
    }

    fun registerAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.add(adapterDelegate)
    }

    fun unRegisterAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.remove(adapterDelegate)
    }

    open fun setData(list: MutableList<Any>) {
        data = list
        notifyDataSetChanged()
    }

    open fun appendData(list: MutableList<Any>) {
        data.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component<*> {
        Log.e(TAG, "onCreateViewHolder: ", NullPointerException())
        Log.d(TAG, "onCreateViewHolder() called with: parent = $parent, viewType = $viewType")
        val delegate = getDelegateByViewType(viewType)
        dispatchOnCreateViewHolderStart(delegate, viewType)
        val component = delegate.onCreateViewHolder(parent, viewType)
        dispatchOnCreateViewHolderEnd(delegate, viewType, component)
        return component
    }

    private fun dispatchOnCreateViewHolderStart(delegate: AdapterDelegate<*, *>?, viewType: Int) {
        hooks.forEach {
            it.onCreateViewHolderStart(delegate, viewType)
        }
    }

    private fun dispatchOnCreateViewHolderEnd(
        delegate: AdapterDelegate<*, *>?,
        viewType: Int,
        component: Component<*>
    ) {
        hooks.forEach {
            it.onCreateViewHolderEnd(delegate, viewType, component)
        }
    }

    override fun getItemCount(): Int {
        Log.e(TAG, "getItemCount: ", NullPointerException())
        return data?.size ?: 0
    }

    override fun onBindViewHolder(component: Component<*>, position: Int) {
        Log.e(TAG, "onBindViewHolder: ", NullPointerException())
        Log.d(TAG, "onBindViewHolder() called with: component = $component, position = $position")
        val delegate = getDelegateByComponent(component)
        val data = getItemData(position)
        dispatchOnBindViewHolderStart(delegate, component, data, position, mutableListOf())
        delegate.onBindViewHolder(
            component,
            data,
            position,
            mutableListOf(),
            this
        )
        dispatchOnBindViewHolderEnd(delegate, component, data, position, mutableListOf())
    }

    override fun onBindViewHolder(
        component: Component<*>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        Log.e(TAG, "onBindViewHolder: ", NullPointerException())
        Log.d(
            TAG,
            "onBindViewHolder() called with: component = $component, position = $position, payloads = $payloads"
        )
        val delegate = getDelegateByComponent(component)
        val data = getItemData(position)
        dispatchOnBindViewHolderStart(delegate, component, data, position, payloads)
        delegate.onBindViewHolder(
            component,
            data,
            position,
            payloads,
            this
        )
        dispatchOnBindViewHolderEnd(delegate, component, data, position, payloads)
    }

    private fun dispatchOnBindViewHolderStart(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    ) {
        hooks.forEach {
            it.onBindViewHolderStart(delegate, component, data, position, payloads)
        }
    }

    private fun dispatchOnBindViewHolderEnd(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    ) {
        hooks.forEach {
            it.onBindViewHolderEnd(delegate, component, data, position, payloads)
        }
    }

    open fun getItemData(position: Int): Any {
        return data[position]
    }

    override fun getItemViewType(position: Int): Int {
        Log.e(TAG, "getItemViewType: ", NullPointerException())
        Log.d(TAG, "getItemViewType() called with: position = $position")
        var itemViewType: Int
        val itemData = getItemData(position)

        val delegate: AdapterDelegate<*, *>? = adapterDelegates.firstOrNull {
            it.delegate(itemData)
        } ?: defaultAdapterDelegate

        itemViewType = delegate?.getItemViewType(itemData, position)
            ?: throw DelegateNotFoundException("$position , $itemData ,找不到对应的 AdapterDelegate，请注册")

        if (itemViewType == 0) {
            itemViewType = View.generateViewId()
        }
        viewTypeDelegateMapper[itemViewType] = delegate
        return itemViewType
    }

    private fun getDelegateByComponent(component: Component<*>): AdapterDelegate<*, *> {
        return getDelegateByViewType(component.itemViewType)
    }

    private fun getDelegateByViewType(viewType: Int): AdapterDelegate<*, *> {
        return viewTypeDelegateMapper[viewType] ?: defaultAdapterDelegate
        ?: throw DelegateNotFoundException("${viewType} 找不到对应的 Delegate")
    }

    override fun getItemId(position: Int): Long {
        Log.d(TAG, "getItemId() called with: position = $position")
        val itemData = getItemData(position)
        val delegate = getDelegateByViewType(getItemViewType(position))
        return delegate.getItemId(itemData, position) ?: RecyclerView.NO_ID
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
        Log.e(TAG, "onViewAttachedToWindow: ", NullPointerException(""))
        Log.d(TAG, "onViewAttachedToWindow() called with: holder = $holder")
    }

    override fun onViewDetachedFromWindow(holder: Component<*>) {
        holder.onViewDetachedFromWindow(this)
        Log.d(TAG, "onViewDetachedFromWindow() called with: holder = $holder")
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        Log.d(TAG, "onAttachedToRecyclerView() called with: recyclerView = $recyclerView")
        onItemClickListener?.let {
            recyclerView.setOnItemClickListener { v, p ->
                it.onItemClick(v, p, getItemData(p))
            }
        }
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

//    private fun checkEmptyStatus() {
//        if (itemCount == 0) {
//            state = UltraRecyclerView.State.Empty
//            notifyDataSetChanged()
//        }
//    }

    interface OnItemClickListener {
        fun onItemClick(v: View, p: Int, data: Any)
    }
}