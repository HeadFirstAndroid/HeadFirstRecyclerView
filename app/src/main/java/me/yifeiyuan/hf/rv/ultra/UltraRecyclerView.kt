package me.yifeiyuan.hf.rv.ultra

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 程序亦非猿 on 2021/9/17.
 */
class UltraRecyclerView : RecyclerView {

    companion object {
        private const val TAG = "UltraRecyclerView"
    }

    private var normalAdapter: ComponentAdapter? = null
    private var errorAdapter: Adapter<ViewHolder>? = null
    private var emptyAdapter: Adapter<ViewHolder>? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {

    }

    private var currentState: State = State.Normal

    fun setAdapters(
        normalAdapter: ComponentAdapter,
        errorAdapter: Adapter<ViewHolder>? = null,
        emptyAdapter: Adapter<ViewHolder>? = null
    ) {
        this.normalAdapter = normalAdapter
        this.errorAdapter = errorAdapter
        this.emptyAdapter = emptyAdapter
    }

    fun switchState(newState: State) {
        if (currentState == newState) {
            return
        }
        currentState = newState

        when (currentState) {
            State.Normal -> {
                adapter = normalAdapter
            }
            is State.Error -> {
                adapter = errorAdapter
            }
            is State.Empty -> {
                adapter = emptyAdapter
            }
            else -> {
                adapter = normalAdapter
            }
        }
    }

    sealed class State {
        object Normal : State()
        class Error : State()
        class Empty : State()
    }
}