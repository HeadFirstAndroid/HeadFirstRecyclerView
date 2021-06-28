package me.yifeiyuan.hf.rv;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import me.yifeiyuan.hf.rv.ultra.Component;
import me.yifeiyuan.hf.rv.ultra.ComponentAdapter;
import me.yifeiyuan.hf.rv.ultra.AdapterDelegate;

/**
 * Created by 程序亦非猿 on 2021/6/8.
 */
class DelegateImpJava implements AdapterDelegate {

    @NotNull
    @Override
    public Component onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NotNull Component holder, int position, @NotNull List<Object> payloads, @Nullable Object model, @NotNull ComponentAdapter adapter) {

    }

    @Override
    public long getItemId(@NotNull Object model, int position) {
        return 0;
    }

    @Override
    public int getItemViewType(@NotNull Object model, int position) {
        return 0;
    }

    @Override
    public void onViewAttachedToWindow(@NotNull Component component, @NotNull ComponentAdapter adapter) {

    }

    @Override
    public void onViewDetachedFromWindow(@NotNull Component component, @NotNull ComponentAdapter adapter) {

    }

    @Override
    public boolean onFailedToRecycleView(@NotNull Component component, @NotNull ComponentAdapter adapter) {
        return false;
    }

    @Override
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView, @NotNull ComponentAdapter componentAdapter) {

    }

    @Override
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView, @NotNull ComponentAdapter componentAdapter) {

    }

    @Override
    public void onViewRecycled(@NotNull Component component, @NotNull ComponentAdapter adapter) {

    }
}
