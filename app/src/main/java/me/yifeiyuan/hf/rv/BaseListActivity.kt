package me.yifeiyuan.hf.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class BaseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }
}