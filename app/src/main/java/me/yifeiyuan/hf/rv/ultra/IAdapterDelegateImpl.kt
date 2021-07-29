package me.yifeiyuan.hf.rv.ultra

import android.view.ViewGroup

class IAdapterDelegateImpl  : AdapterDelegate<DefaultModel,DefaultComponent> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultComponent {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(model: Any, position: Int): Int {
        TODO("Not yet implemented")
    }

}