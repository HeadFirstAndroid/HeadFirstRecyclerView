package me.yifeiyuan.hf.rv.ultra

import android.os.SystemClock
import android.util.Log

/**
 * Created by 程序亦非猿 on 2021/9/17.
 */
class AdapterDelegateApm : AdapterHook {

    companion object {
        private const val TAG = "DelegateApm"
    }

    private var createStartTime: Long = 0
    private var bindStartTime: Long = 0

    override fun onCreateViewHolderStart(delegate: AdapterDelegate<*, *>?, viewType: Int) {
        Log.d(
            TAG,
            "${delegate?.javaClass?.simpleName} 开始创建 Component : viewType = $viewType"
        )
        createStartTime = SystemClock.uptimeMillis()
    }

    override fun onCreateViewHolderEnd(
        delegate: AdapterDelegate<*, *>?,
        viewType: Int,
        component: Component<*>
    ) {
        val endTime = SystemClock.uptimeMillis()
        val cost = endTime - createStartTime
        Log.d(
            TAG,
            "${delegate?.javaClass?.simpleName} 完成创建: Component = $component，cost = $cost (毫秒)"
        )
    }

    override fun onBindViewHolderStart(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    ) {
        bindStartTime = SystemClock.uptimeMillis()
        Log.d(
            TAG,
            "${delegate?.javaClass?.simpleName} 开始绑定 $component :  data = $data, position = $position, payloads = $payloads"
        )
    }

    override fun onBindViewHolderEnd(
        delegate: AdapterDelegate<*, *>,
        component: Component<*>,
        data: Any,
        position: Int,
        payloads: MutableList<Any>
    ) {

        val endTime = SystemClock.uptimeMillis()
        val cost = endTime - bindStartTime
        Log.d(
            TAG,
            "${delegate?.javaClass?.simpleName} 完成绑定: position = $position, cost = $cost (毫秒)"
        )
    }
}