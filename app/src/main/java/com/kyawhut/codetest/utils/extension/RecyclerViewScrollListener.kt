package com.kyawhut.codetest.utils.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class RecyclerViewScrollListener(
    private val listenerType: ListenerType,
    private val onLoadMoreTop: () -> Unit = {},
    private val onLoadMoreEnd: () -> Unit = {}
) : RecyclerView.OnScrollListener() {

    private var isListTopReach = false
    private var isListEndReach = false
    private var previousDy = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (previousDy < dy) {
            isListTopReach = false
        } else if (previousDy > dy) {
            isListEndReach = false
        }
        previousDy = dy
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            val firstItemPosition = when (val layout = recyclerView.layoutManager) {
                is LinearLayoutManager -> layout.findFirstVisibleItemPosition()
                else -> throw Exception("Unknown Layout manager.")
            }
            val visibleItemCount = recyclerView.childCount
            val totalItemCount = recyclerView.layoutManager!!.itemCount
            if (firstItemPosition == 0 && !isListTopReach && (listenerType == ListenerType.TOP || listenerType == ListenerType.BOTH)) {
                isListTopReach = true
                onLoadMoreTop()
            } else if ((visibleItemCount + firstItemPosition) >= totalItemCount && !isListEndReach && (listenerType == ListenerType.END || listenerType == ListenerType.BOTH)) {
                isListEndReach = true
                onLoadMoreEnd()
            }
        }
    }
}

enum class ListenerType {
    TOP, END, BOTH
}

fun RecyclerView.onLoadMoreTop(onLoadMoreTop: () -> Unit) {
    this.addOnScrollListener(RecyclerViewScrollListener(ListenerType.TOP, onLoadMoreTop))
}

fun RecyclerView.onLoadMoreEnd(onLoadMoreEnd: () -> Unit) {
    this.addOnScrollListener(
        RecyclerViewScrollListener(
            ListenerType.END,
            onLoadMoreEnd = onLoadMoreEnd
        )
    )
}

fun RecyclerView.onLoadMore(onLoadMoreTop: () -> Unit, onLoadMoreEnd: () -> Unit) {
    this.addOnScrollListener(
        RecyclerViewScrollListener(
            ListenerType.BOTH,
            onLoadMoreTop,
            onLoadMoreEnd
        )
    )
}
