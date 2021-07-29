package me.yifeiyuan.hf.rv.ultra

import android.view.ViewGroup

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
object Ultra{

    private val adapterDelegates: MutableList<AdapterDelegate<*,*>> = mutableListOf()
    private val delegateViewTypeMapper: MutableMap<Int, AdapterDelegate<*,*>?> = mutableMapOf()

    fun registerAdapterDelegate(adapterDelegate: AdapterDelegate<*,*>) {
        adapterDelegates.add(adapterDelegate)
    }

    fun unRegisterAdapterDelegate(adapterDelegate: AdapterDelegate<*,*>) {
        adapterDelegates.remove(adapterDelegate)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component<*> {
        val localDelegate = delegateViewTypeMapper[viewType]
        var component: Component<*>? = null
        if (localDelegate != null) {
            component = localDelegate.onCreateViewHolder(parent, viewType)
        }
        if (component == null) {
            component =  DefaultComponent(parent)
        }
        return component
    }

    fun getItemViewType(model: Any, position: Int): Int {
        TODO("Not yet implemented")
    }

    fun getItemId(itemData: Any, position: Int): Long {
        TODO("Not yet implemented")
    }

}