package com.sournary.awesomeenglish.rx

import io.reactivex.Scheduler

/**
 * Created: 29/10/2018
 * By: Sang
 * Description:
 */
interface SchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler

    fun computation(): Scheduler
}
