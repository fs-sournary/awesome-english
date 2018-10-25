package com.sournary.awesomeenglish

import androidx.lifecycle.ViewModel
import com.sournary.awesomeenglish.util.SingleLiveEvent

/**
 * Created by fs-sournary.
 * Date: 10/25/18.
 * Description:
 */
class MainViewModel : ViewModel() {

    val onBackPressEvent = SingleLiveEvent<Unit>()
}
