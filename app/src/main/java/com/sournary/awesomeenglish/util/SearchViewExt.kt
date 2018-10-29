package com.sournary.awesomeenglish.util

import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.SearchView
import com.sournary.awesomeenglish.R
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

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

fun SearchView.customVoiceSearch(
    @DrawableRes imageId: Int = R.drawable.ic_voice_search,
    @DimenRes paddingId: Int = R.dimen.dp_4
) {
    val searchVoiceButton = findViewById<ImageView>(R.id.search_voice_btn)
    searchVoiceButton.setImageResource(imageId)
    val padding = context.resources.getDimensionPixelOffset(paddingId)
    searchVoiceButton.setPadding(padding, 0, padding, 0)
}

fun SearchView.enableVoiceSearch() {
    with(context as Activity) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        setSearchableInfo(searchManager.getSearchableInfo(componentName))
    }
}

fun SearchView.querySearch(): Observable<String> {
    val subject = PublishSubject.create<String>()
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            subject.onComplete()
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            subject.onNext(newText)
            return true
        }
    })
    return subject
}
