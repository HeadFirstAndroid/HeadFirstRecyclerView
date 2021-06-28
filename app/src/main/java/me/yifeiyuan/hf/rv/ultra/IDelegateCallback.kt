package me.yifeiyuan.hf.rv.ultra


/**
 * Created by 程序亦非猿 on 2021/6/28.
 */
interface IDelegateCallback {

    fun onViewDetachedFromWindow(adapter: ComponentAdapter) {}

    fun onViewAttachedToWindow(adapter: ComponentAdapter) {}

    fun onViewRecycled(adapter: ComponentAdapter) {}

    fun onFailedToRecycleView(adapter: ComponentAdapter): Boolean = false

}