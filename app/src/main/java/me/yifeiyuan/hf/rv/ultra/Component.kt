package me.yifeiyuan.hf.rv.ultra

import android.content.Context
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
abstract class Component<T>(itemView: View) : RecyclerView.ViewHolder(itemView), LifecycleObserver {

    companion object {
        private const val TAG = "Component"
    }

    var context: Context = itemView.context

    private var isVisible = false

    internal fun bind(model: Any, position: Int, payloads: MutableList<Any>, adapter: ComponentAdapter) {
        if (payloads.isEmpty()) {
            onBind(model as T, position, adapter)
        } else {
            onBind(model as T, position, payloads, adapter)
        }
    }

    internal abstract fun onBind(model: T, position: Int, adapter: ComponentAdapter)

    open fun onBind(
        model: Any?,
        position: Int,
        payloads: MutableList<Any>,
        adapter: ComponentAdapter
    ) {
    }

    fun onViewDetachedFromWindow(adapter: ComponentAdapter) {}

    fun onViewAttachedToWindow(adapter: ComponentAdapter) {}

    fun onViewRecycled(adapter: ComponentAdapter) {}

    fun onFailedToRecycleView(adapter: ComponentAdapter): Boolean = false

    fun requestReRender(adapter: ComponentAdapter) {
        adapter.notifyItemChanged(position)
    }

    protected open fun onVisibilityChanged(visible: Boolean, adapter: ComponentAdapter) {
        isVisible = visible
    }

    open fun isVisible(): Boolean {
        return isVisible
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        if (context is LifecycleOwner) {
            (context as LifecycleOwner).lifecycle.removeObserver(this)
        }
    }

}