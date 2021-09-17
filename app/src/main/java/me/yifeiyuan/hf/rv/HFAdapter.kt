package me.yifeiyuan.hf.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import me.yifeiyuan.hf.rv.ultra.Component
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter
import me.yifeiyuan.hf.rv.ultra.DefaultModel

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class HFAdapter : ComponentAdapter() {

    private val showcaseAdapterDelegate = ShowcaseAdapterDelegate()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseComponent {
        return showcaseAdapterDelegate.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return 20
    }
}