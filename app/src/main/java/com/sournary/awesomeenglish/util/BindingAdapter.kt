package com.sournary.awesomeenglish.util

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.sournary.awesomeenglish.model.EVWord
import com.sournary.awesomeenglish.ui.menu.SearchWordAdapter

/**
 * Created: 29/10/2018
 * By: Sang
 * Description:
 */
object BindingAdapter {

    @BindingAdapter("searchItems")
    @JvmStatic
    fun RecyclerView.getSearchWords(words: PagedList<EVWord>) {
        when (adapter) {
            is SearchWordAdapter -> (adapter as SearchWordAdapter).submitList(words)
        }
    }
}
