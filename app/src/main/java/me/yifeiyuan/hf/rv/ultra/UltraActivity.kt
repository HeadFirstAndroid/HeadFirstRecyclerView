package me.yifeiyuan.hf.rv.ultra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import me.yifeiyuan.hf.rv.R
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter.Companion.registerGlobalAdapterDelegate

class UltraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultra)

        ComponentAdapter().apply {

            registerAdapterDelegate(object : AdapterDelegate<Any, DefaultComponent> {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): DefaultComponent {
                    TODO()
                }
            })
        }
    }
}