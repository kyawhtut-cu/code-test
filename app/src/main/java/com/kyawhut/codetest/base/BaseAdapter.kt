package com.kyawhut.codetest.base

import androidx.recyclerview.widget.RecyclerView

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseAdapter<D>(
    protected val itemClickListener: (Int, D) -> Unit = { _, _ -> }
) : RecyclerView.Adapter<BaseViewHolder<*, D>>() {

    private val itemList: MutableList<D> = mutableListOf()

    override fun onBindViewHolder(holder: BaseViewHolder<*, D>, position: Int) {
        holder.data = itemList[position]
        holder.bind()
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
        itemList.add(index, data)
        notifyItemChanged(index)
    }

    fun get(index: Int): D? {
        return itemList[index]
    }

    fun get(predicate: (D) -> Boolean): D {
        return itemList.first(predicate)
    }

    fun indexOf(data: D): Int {
        return itemList.indexOf(data)
    }

    fun indexOfFirst(predicate: (D) -> Boolean): Int {
        return itemList.indexOfFirst(predicate)
    }

    fun clear() {
        val totalCount = itemList.size
        itemList.clear()
        notifyItemRangeRemoved(0, totalCount)
    }

}
