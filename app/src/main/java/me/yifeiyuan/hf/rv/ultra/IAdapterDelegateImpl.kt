package me.yifeiyuan.hf.rv.ultra

import android.view.ViewGroup

class IAdapterDelegateImpl<T,VH :Component<T>> : AdapterDelegate<T,VH> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(model: Any, position: Int): Int {
        TODO("Not yet implemented")
    }

}