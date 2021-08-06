package me.yifeiyuan.hf.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.yifeiyuan.hf.rv.ultra.Component
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter
import me.yifeiyuan.hf.rv.ultra.DefaultModel

/**
 * Created by 程序亦非猿 on 2021/6/4.
 */
class HFAdapter : ComponentAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseComponent {
        return ShowcaseComponent.newInstance(LayoutInflater.from(parent.context).inflate(R.layout.simple_item,parent,false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ShowcaseComponent(view: View) : Component<ShowcaseModel>(view){
        companion object{
            fun newInstance(view: View): ShowcaseComponent{
                return ShowcaseComponent(view)
            }
        }

        override fun onBind(model: ShowcaseModel, position: Int, adapter: ComponentAdapter) {
        }
    }
}