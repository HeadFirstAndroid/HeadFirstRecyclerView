package me.yifeiyuan.hf.rv.paging

import androidx.paging.PagingDataAdapter
import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * Created by 程序亦非猿 on 2021/6/28.
 */
class MyPagingSource : PagingSource<String, Goods>() {

    override fun getRefreshKey(state: PagingState<String, Goods>): String? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Goods> {
        TODO("Not yet implemented")
//        PagingDataAdapter
    }
}