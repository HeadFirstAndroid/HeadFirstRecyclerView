package me.yifeiyuan.hf.rv.ultra

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

/**
 * Created by 程序亦非猿 on 2021/8/6.
 */
class ComponentListAdapter<T : ComponentDataModel> : ComponentAdapter() {

    private val diffCallback = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areItemsTheSame(newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }

        override fun getChangePayload(oldItem: T, newItem: T): Any? {
            return oldItem.getChangePayload(newItem)
        }
    }

    private val mDiffer: AsyncListDiffer<T> = AsyncListDiffer(this, diffCallback)

    fun submitList(newList: MutableList<T>) {
        if (mDiffer.currentList == newList) {
            mDiffer.submitList(mutableListOf<T>().apply {
                addAll(newList)
            })
        } else {
            mDiffer.submitList(newList)
        }
    }

    fun submitList(newList: MutableList<T>, commitCallback: Runnable?) {
        if (mDiffer.currentList == newList) {
            mDiffer.submitList(mutableListOf<T>().apply {
                addAll(newList)
            }, commitCallback)
        } else {
            mDiffer.submitList(newList, commitCallback)
        }
    }

    override fun setData(list: MutableList<Any>) {
        throw UnsupportedOperationException("Use submitList(newList) instead!")
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    override fun getItemData(position: Int): Any {
        return mDiffer.currentList[position] as T
    }

}