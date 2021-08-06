package me.yifeiyuan.hf.rv.ultra

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
object Ultra {

    private val adapterDelegates: MutableList<AdapterDelegate<*, *>> = mutableListOf()
    private val delegateViewTypeMapper: MutableMap<Int, AdapterDelegate<*, *>?> = mutableMapOf()

    fun registerAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.add(adapterDelegate)
    }

    fun unRegisterAdapterDelegate(adapterDelegate: AdapterDelegate<*, *>) {
        adapterDelegates.remove(adapterDelegate)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component<*> {
        val localDelegate = delegateViewTypeMapper[viewType]
        var component: Component<*>? = null
        if (localDelegate != null) {
            component = localDelegate.onCreateViewHolder(parent, viewType)
        }
        if (component == null) {
            component = DefaultComponent(parent)
        }
        return component
    }

    fun getItemViewType(itemData: Any, position: Int): Int {
        var itemViewType = 0
        adapterDelegates.forEach {
            if (it.isDelegatedTo(itemData)) {
                val type = it.getItemViewType(itemData, position)
                if (type > 0) {
                    itemViewType = type
                    delegateViewTypeMapper[type] = it
                    return@forEach
                }
            }
        }
        return itemViewType
    }

    fun getItemId(itemData: Any, position: Int): Long {
        var itemId = RecyclerView.NO_ID
        adapterDelegates.forEach {
            if (it.isDelegatedTo(itemData)) {
                val id = it.getItemId(itemData, position)
                if (id >= 0) {
                    itemId = id
                    return@forEach
                }
            }
        }
        return itemId
    }

}