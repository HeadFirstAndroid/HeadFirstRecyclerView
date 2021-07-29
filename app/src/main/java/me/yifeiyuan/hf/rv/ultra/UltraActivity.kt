package me.yifeiyuan.hf.rv.ultra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import me.yifeiyuan.hf.rv.R

class UltraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultra)

        ComponentAdapter().apply {

            registerAdapterDelegate(object : AdapterDelegate<DefaultModel, DefaultComponent> {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): DefaultComponent {
                    TODO()
                }

                override fun getItemViewType(model: Any, position: Int): Int {
                    TODO("Not yet implemented")
                }

                override fun isDelegatedTo(model: Any?): Boolean {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}