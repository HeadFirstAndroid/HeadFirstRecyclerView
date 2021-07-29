package me.yifeiyuan.hf.rv;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import me.yifeiyuan.hf.rv.ultra.Component;
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter;
import me.yifeiyuan.hf.rv.ultra.AdapterDelegate;
import me.yifeiyuan.hf.rv.ultra.DefaultComponent;
import me.yifeiyuan.hf.rv.ultra.DefaultModel;

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
class DefaultDelegateImpJava implements AdapterDelegate<DefaultModel, DefaultComponent> {

    @Override
    public long getItemId(@NotNull Object model, int position) {
        return 0;
    }

    @Override
    public int getItemViewType(@NotNull Object model, int position) {
        return 0;
    }

    @NotNull
    @Override
    public DefaultComponent onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public boolean isDelegatedTo(@Nullable Object model) {
        return false;
    }
}
