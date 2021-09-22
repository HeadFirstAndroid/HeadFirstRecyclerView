package me.yifeiyuan.hf.rv.ultra


/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
object Ultra {

    internal val adapterDelegates: MutableList<AdapterDelegate<*, *>> = mutableListOf()

    internal val hooks: MutableList<AdapterHook> = mutableListOf<AdapterHook>().apply {
        add(AdapterDelegateApm())
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
}