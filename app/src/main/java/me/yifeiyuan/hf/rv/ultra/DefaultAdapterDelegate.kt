package me.yifeiyuan.hf.rv.ultra

import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by 程序亦非猿 on 2021/9/17.
 */

class DefaultAdapterDelegate : AdapterDelegate<Any, DefaultComponent> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultComponent {
        return DefaultComponent(TextView(parent.context))
    }

}

class DefaultComponent(v: View) : Component<Any>(v) {
    override fun onBind(model: Any, position: Int, adapter: ComponentAdapter) {
        (itemView as TextView).run {
            text = "$model 没有被正确代理，position = ${position}"
        }
    }

}

open class DefaultModel