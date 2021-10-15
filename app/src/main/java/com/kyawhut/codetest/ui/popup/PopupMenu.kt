package com.kyawhut.codetest.ui.popup

import android.content.Context
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.kyawhut.codetest.R
import android.widget.PopupMenu as AndroidPopupMenu

/**
 * @author kyawhtut
 * @date 10/15/21
 */
class PopupMenu private constructor(
    private val context: Context,
    private val anchorView: View,
    private val menuTitle: String,
    private val menuItemList: List<String>,
    private val menuItemClickListener: (String) -> Unit,
) : AndroidPopupMenu.OnMenuItemClickListener {

    private val popupMenu = AndroidPopupMenu(context, anchorView)

    init {
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.menu.let {
            it.findItem(R.id.action_title).title = menuTitle
            menuItemList.forEach { menu ->
                it.add(menu)
            }
        }

        popupMenu.setOnMenuItemClickListener(this)
    }

    fun show() {
        popupMenu.show()
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        menuItemClickListener(item.title.toString())
        popupMenu.dismiss()
        return true
    }

    class Builder(private val context: Context) {
        var menuTitle: String = ""
        var menuItemList: List<String> = mutableListOf()
        private var menuItemClickListener: (String) -> Unit = {}

        fun setOnMenuClickListener(callback: (String) -> Unit): Builder {
            menuItemClickListener = callback
            return this
        }

        fun show(anchorView: View) {
            PopupMenu(
                context,
                anchorView,
                menuTitle,
                menuItemList,
                menuItemClickListener
            ).show()
        }
    }

}

fun FragmentActivity.showPopupMenuBuilder(
    menuTitle: String,
    menuItemList: List<String>
): PopupMenu.Builder {
    return PopupMenu.Builder(this).apply {
        this.menuTitle = menuTitle
        this.menuItemList = menuItemList
    }
}

fun Fragment.showPopupMenuBuilder(
    menuTitle: String,
    menuItemList: List<String>
): PopupMenu.Builder {
    return PopupMenu.Builder(requireContext()).apply {
        this.menuTitle = menuTitle
        this.menuItemList = menuItemList
    }
}
