package me.yifeiyuan.hf.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HFAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = HFAdapter()
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = HFAnimator()
    }


    override fun onOptionsItemSelected(item: MenuItem)  = when (item.itemId) {
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