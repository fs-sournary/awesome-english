package com.sournary.awesomeenglish.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * Created by fs-sournary.
 * Date: 10/27/18.
 * Description:
 */
fun Fragment.showKeyBoard(){
    with(context as Activity){
        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}
