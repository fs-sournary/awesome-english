package com.sournary.awesomeenglish.util

import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.SearchView
import com.sournary.awesomeenglish.R

/**
 * Created by fs-sournary.
 * Date: 10/25/18.
 * Description:
 */
fun SearchView.customTextSearch(textSize: Float = 16f) {
    val searchText = findViewById<View>(R.id.search_src_text)
    (searchText as EditText).setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
}

fun SearchView.customSearchCloseButton(@DrawableRes imageId: Int = R.drawable.ic_search_close) {
    val searchCloseButton = findViewById<ImageView>(R.id.search_close_btn)
    searchCloseButton.setImageResource(imageId)
}

fun SearchView.customVoiceSearch(@DrawableRes imageId: Int = R.drawable.ic_voice_search) {
    val searchVoiceButton = findViewById<ImageView>(R.id.search_voice_btn)
    searchVoiceButton.setImageResource(imageId)
}

fun SearchView.enableVoiceSearch() {
    with(context as Activity) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        setSearchableInfo(searchManager.getSearchableInfo(componentName))
    }
}
