package me.yifeiyuan.hf.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import me.yifeiyuan.hf.rv.ultra.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = ComponentAdapter().apply {
            setData(mockData())
            registerAdapterDelegate(ShowcaseAdapterDelegate())
        }
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = HFAnimator()
//        recyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
//            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//                return true
//            }
//
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
//            }
//
//            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
//            }
//        })

//        val k = object : AdapterDelegateJava(){
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultComponent {
//                return DefaultComponent()
//            }
//        }
//        k.javaClass.genericSuperclass

        IAdapterDelegateImpl().run {
            Log.e(TAG, "onCreate:DefaultModel: ${delegate(DefaultModel())}")
            Log.e(TAG, "onCreate:Any: ${delegate(Any())}")
            Log.e(TAG, "onCreate:DefaultModel2: ${delegate(DefaultModel2())}")
        }
    }

    private fun mockData(): MutableList<Any> {
        return mutableListOf<Any>().apply{
            repeat(30){
                add(ShowcaseModel())
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.linear -> {
            recyclerView.layoutManager = HFLinearLayoutManager(this)
            true
        }
        R.id.grid -> {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            true
        }
        R.id.stag -> {
            recyclerView.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
            true
        }
        else -> {
            super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_rv, menu)
        return true
    }
}