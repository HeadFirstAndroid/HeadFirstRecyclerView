package me.yifeiyuan.hf.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class HFAdapter : RecyclerView.Adapter<HFAdapter.Component>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Component {
        return Component.newInstance(LayoutInflater.from(parent.context).inflate(R.layout.simple_item,parent,false))
    }

    override fun onBindViewHolder(holder: Component, position: Int) {
    }

    override fun getItemCount(): Int {
        return 20
    }

    class Component(view: View) : RecyclerView.ViewHolder(view){
        companion object{
            fun newInstance(view: View): Component{
                return Component(view)
            }
        }
    }
}