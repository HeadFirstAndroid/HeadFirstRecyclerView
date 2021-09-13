package me.yifeiyuan.hf.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import me.yifeiyuan.hf.rv.HFAdapter.ShowcaseComponent
import me.yifeiyuan.hf.rv.ultra.AdapterDelegate
import me.yifeiyuan.hf.rv.ultra.Component
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter

/**
 * Created by 程序亦非猿 on 2021/8/6.
 */
class ShowcaseAdapterDelegate : AdapterDelegate<ShowcaseModel, ShowcaseComponent> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseComponent {
        return ShowcaseComponent.newInstance(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun getItemViewType(model: Any, position: Int): Int {
        return R.layout.simple_item
    }

    override fun onBindViewHolder(
        holder: Component<*>,
        itemData: Any,
        position: Int,
        payloads: MutableList<Any>,
        adapter: ComponentAdapter
    ) {
        super.onBindViewHolder(holder, itemData, position, payloads, adapter)
    }

}