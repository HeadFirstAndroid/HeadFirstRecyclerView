package me.yifeiyuan.hf.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.yifeiyuan.hf.rv.ultra.Component
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter
import me.yifeiyuan.hf.rv.ultra.Ultra
import me.yifeiyuan.hf.rv.ultra.UltraRecyclerView

class MultiStatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_states)

        val rv = findViewById<UltraRecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(this@MultiStatesActivity)
        }

        val normalAdapter = ComponentAdapter().apply {
            setData(mockData())
            registerAdapterDelegate(ShowcaseAdapterDelegate())
        }

//        normalAdapter.onItemClickListener = { v,i,data->
//
//        }

//        rv.setAdapters(normalAdapter, EmptyAdapter(), ErrorAdapter())
        rv.setAdapters(normalAdapter, ErrorAdapter(), EmptyAdapter())
        rv.setRecycledViewPool(RecyclerView.RecycledViewPool())

        Handler().postDelayed({
            rv.switchState(UltraRecyclerView.State.Empty)
            Handler().postDelayed({
                rv.switchState(UltraRecyclerView.State.Error)
                Handler().postDelayed({
                    rv.switchState(UltraRecyclerView.State.Normal)
                }, 2000)
            }, 2000)
        }, 2000)
    }

    private fun mockData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            repeat(30) {
                add(ShowcaseModel())
            }
        }
    }

    class EmptyAdapter : RecyclerView.Adapter<EmptyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {
            return EmptyViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.component_empty_state, parent, false)
            )
        }

        override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {
        }

        override fun getItemCount(): Int = 1
    }

    class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ErrorAdapter : RecyclerView.Adapter<ErrorViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ErrorViewHolder {
            return ErrorViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.component_error_state, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ErrorViewHolder, position: Int) {
        }

        override fun getItemCount(): Int = 1
    }

    class ErrorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}