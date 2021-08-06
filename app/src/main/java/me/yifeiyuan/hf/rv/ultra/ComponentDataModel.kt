package me.yifeiyuan.hf.rv.ultra

/**
 * Created by 程序亦非猿 on 2021/7/29.
 */
interface ComponentDataModel {

    fun areItemsTheSame(newItem: ComponentDataModel): Boolean

    fun areContentsTheSame(newItem: ComponentDataModel): Boolean

    fun getChangePayload(newItem: ComponentDataModel): Any?
}