package me.yifeiyuan.hf.rv.ultra

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
abstract class Component<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private const val TAG = "Component"
    }

    var context: Context = itemView.context

    fun bind(model: Any?, position: Int, payloads: MutableList<Any>, adapter: ComponentAdapter) {
        if (payloads.isEmpty()) {
            onBind(model as T, position, adapter)
        } else {
            onBind(model as T, position, payloads, adapter)
        }
    }

    abstract fun onBind(model: T, position: Int, adapter: ComponentAdapter)

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
        adapter.notifyItemChanged(adapterPosition)
    }
}