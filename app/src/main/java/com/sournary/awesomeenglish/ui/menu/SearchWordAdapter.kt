package com.sournary.awesomeenglish.ui.menu

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
class SearchWordAdapter : PagedListAdapter<EVWord, SearchWordViewHolder>(SEARCH_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchWordViewHolder =
        SearchWordViewHolder.create(parent)

    override fun onBindViewHolder(holder: SearchWordViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    companion object {

        val SEARCH_COMPARATOR = object : DiffUtil.ItemCallback<EVWord>() {

            override fun areItemsTheSame(oldItem: EVWord, newItem: EVWord): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: EVWord, newItem: EVWord): Boolean =
                oldItem.word == newItem.word
        }
    }
}
