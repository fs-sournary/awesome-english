package com.sournary.awesomeenglish.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sournary.awesomeenglish.databinding.ItemSearchWordBinding
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
class SearchWordViewHolder(private val itemSearchWordBinding: ItemSearchWordBinding) :
    RecyclerView.ViewHolder(itemSearchWordBinding.root) {

    fun bindView(word: EVWord?) {
        with(itemSearchWordBinding) {
            evWord = word ?: EVWord()
            executePendingBindings()
        }
    }

    companion object {

        fun create(parent: ViewGroup): SearchWordViewHolder {
            val itemBinding =
                ItemSearchWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SearchWordViewHolder(itemBinding)
        }
    }
}
