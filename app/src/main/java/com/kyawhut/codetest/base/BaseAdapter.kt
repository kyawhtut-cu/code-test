package com.kyawhut.codetest.base

import androidx.recyclerview.widget.RecyclerView

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseAdapter<D> : RecyclerView.Adapter<BaseViewHolder<*, D>>() {

    private val itemList: MutableList<D> = mutableListOf()

    override fun onBindViewHolder(holder: BaseViewHolder<*, D>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(data: D) {
        itemList.add(data)
        notifyItemInserted(itemList.size)
    }

    fun addItem(index: Int, data: D) {
        itemList.add(index, data)
        notifyItemInserted(index)
    }

    fun addAll(data: List<D>) {
        itemList.addAll(itemList.size, data)
        notifyItemRangeInserted(itemList.size - data.size, data.size)
    }

    fun addAll(index: Int, data: List<D>) {
        itemList.addAll(index, data)
        notifyItemRangeInserted(index, data.size)
    }

    fun update(index: Int, data: D) {
        itemList.removeAt(index)
        addItem(index, data)
    }

    fun get(index: Int): D? {
        return itemList[index]
    }

}
