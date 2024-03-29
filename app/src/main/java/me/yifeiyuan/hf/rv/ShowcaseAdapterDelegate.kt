package me.yifeiyuan.hf.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import me.yifeiyuan.hf.rv.ultra.AdapterDelegate
import me.yifeiyuan.hf.rv.ultra.Component
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter

/**
 * Created by 程序亦非猿 on 2021/8/6.
 */
class ShowcaseAdapterDelegate : AdapterDelegate<ShowcaseModel, ShowcaseComponent> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseComponent {
        return ShowcaseComponent.newInstance(
            LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false)
        )
    }

    override fun getItemViewType(model: Any, position: Int): Int {
        return R.layout.simple_item
    }
    
}

class ShowcaseComponent(view: View) : Component<ShowcaseModel>(view){
    companion object{
        fun newInstance(view: View): ShowcaseComponent{
            return ShowcaseComponent(view)
        }
    }

    override fun onBind(model: ShowcaseModel, position: Int, adapter: ComponentAdapter) {
        itemView.setOnClickListener {
            Toast.makeText(context,"onBind Clicks", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBind(
        model: ShowcaseModel,
        position: Int,
        payloads: MutableList<Any>,
        adapter: ComponentAdapter
    ) {
        super.onBind(model, position, payloads, adapter)
    }
}