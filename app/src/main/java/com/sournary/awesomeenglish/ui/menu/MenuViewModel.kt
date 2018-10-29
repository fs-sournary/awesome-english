package com.sournary.awesomeenglish.ui.menu

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagedList
import com.sournary.awesomeenglish.model.EVWord
import com.sournary.awesomeenglish.repository.EVRepository
import com.sournary.awesomeenglish.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
class MenuViewModel(
    private val evRepository: EVRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel(), LifecycleObserver {

    private val compositeDisposable = CompositeDisposable()

    val searchResults = MutableLiveData<PagedList<EVWord>>()

    fun searchWords(searchObservable: Observable<String>) {
        val disposable = searchObservable.debounce(DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .filter { it.isNotEmpty() }
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.io())
            .subscribeBy(
                onNext = {
                    val words = evRepository.getLocalSearchWords(it, LIMIT_QUERY_COUNT).value
                    Log.d(TAG, "word size: $it - ${words?.size}")
                    searchResults.postValue(words)
                },
                onComplete = {}
            )
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun clear() {
        compositeDisposable.clear()
    }

    companion object {

        private const val TAG = "search_word"
        private const val DEBOUNCE_TIME = 300L
        private const val LIMIT_QUERY_COUNT = 40
    }
}
