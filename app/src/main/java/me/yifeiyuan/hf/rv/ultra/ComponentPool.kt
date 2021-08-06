package me.yifeiyuan.hf.rv.ultra

import android.content.ComponentCallbacks2
import android.content.res.Configuration
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool

/**
 * Created by 程序亦非猿 on 2021/8/6.
 */
class ComponentPool : RecycledViewPool(), ComponentCallbacks2 {

    override fun onTrimMemory(level: Int) {
        when (level) {
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL,
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW,
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE ->
                clear()
            ComponentCallbacks2.TRIM_MEMORY_BACKGROUND,
            ComponentCallbacks2.TRIM_MEMORY_COMPLETE,
            ComponentCallbacks2.TRIM_MEMORY_MODERATE,
            ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN -> {
            }
            else -> {
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {}

    override fun onLowMemory() {
        clear()
    }
}