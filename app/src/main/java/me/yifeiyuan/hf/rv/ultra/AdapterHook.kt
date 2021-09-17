package me.yifeiyuan.hf.rv.ultra

/**
 * Created by 程序亦非猿 on 2021/6/28.
 */
interface AdapterHook {

    fun onCreateViewHolderStart(delegate: AdapterDelegate<*, *>?, viewType: Int)

    fun onCreateViewHolderEnd(
        delegate: AdapterDelegate<*, *>?,
        viewType: Int,
        component: Component<*>
    )

    fun onBindViewHolderStart(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    )

    fun onBindViewHolderEnd(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    )
}