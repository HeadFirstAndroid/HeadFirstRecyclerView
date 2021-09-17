package me.yifeiyuan.hf.rv;


import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import me.yifeiyuan.hf.rv.ultra.AdapterDelegate;
import me.yifeiyuan.hf.rv.ultra.Component;
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter;
import me.yifeiyuan.hf.rv.ultra.DefaultComponent;
import me.yifeiyuan.hf.rv.ultra.DefaultModel;

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
abstract class AdapterDelegateJava implements AdapterDelegate<Object, DefaultComponent> {

    @Override
    public long getItemId(@NotNull Object model, int position) {
        return RecyclerView.NO_ID;
    }

    @Override
    public boolean delegate(@Nullable Object model) {
        if (model != null) {
            Type type = ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            return type == model.getClass();
        }
        return false;
    }

    @Override
    public int getItemViewType(@NotNull Object model, int position) {
        return 0;
    }

}
