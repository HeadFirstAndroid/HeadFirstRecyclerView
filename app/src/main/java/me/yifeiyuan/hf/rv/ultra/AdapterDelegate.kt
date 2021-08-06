package me.yifeiyuan.hf.rv.ultra

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.ParameterizedType

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
interface AdapterDelegate<T, VH : Component<T>> {

    companion object {
        private const val TAG = "AdapterDelegate"
    }

    fun isDelegatedTo(model: Any?): Boolean {
        if (model != null) {
            val type =
                (this.javaClass.genericInterfaces[0] as ParameterizedType).actualTypeArguments[0]
            return type == model.javaClass
        }
        return false
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    fun getItemId(model: Any, position: Int): Long = RecyclerView.NO_ID

    fun getItemViewType(model: Any, position: Int):Int
}