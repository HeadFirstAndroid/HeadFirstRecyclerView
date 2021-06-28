package me.yifeiyuan.hf.rv.ultra

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
abstract class Component(itemView: View) : RecyclerView.ViewHolder(itemView), IDelegateCallback {


    fun bind(model: Any?, position: Int, payloads: MutableList<Any>, adapter: ComponentAdapter) {
        if (payloads.isEmpty()) {
            onBind(model, position, adapter)
        } else {
            onBind(model, position, payloads, adapter)
        }
    }

    abstract fun onBind(model: Any?, position: Int, adapter: ComponentAdapter)

    open fun onBind(
        model: Any?,
        position: Int,
        payloads: MutableList<Any>,
        adapter: ComponentAdapter
    ) {
    }

}