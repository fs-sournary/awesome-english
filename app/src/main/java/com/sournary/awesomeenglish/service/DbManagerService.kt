package com.sournary.awesomeenglish.service

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar
import com.sournary.awesomeenglish.R
import com.sournary.awesomeenglish.repository.setting.SettingRepository
import com.sournary.awesomeenglish.util.extractDbZipFile
import org.koin.android.ext.android.inject

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
class DbManagerService : IntentService("DbManagerService") {

    private val settingRepository: SettingRepository by inject()

    private lateinit var notificationManagerCompat: NotificationManagerCompat
    private lateinit var notificationBuilder: NotificationCompat.Builder

    init {
        setIntentRedelivery(true)
    }

    override fun onHandleIntent(intent: Intent?) {
        extractDbZipFile(
            dbName = DB_ZIP_NAME,
            onExtraBeginning = {
                createNotificationChannel()
                showNotification()
                Log.d("DbManagerService", "onExtraBeginning")
            },
            onSuccess = {
                finishProcessNotification(CONTENT_FINISH_EXTRA_DB)
                settingRepository.saveLocalDbStatus(true)
                Log.d("DbManagerService", "onSuccess")
            },
            onFailed = {
                finishProcessNotification(it)
                settingRepository.saveLocalDbStatus(false)
                Log.d("DbManagerService", "onFailed: $it")
            }
        )
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val dbChannel = NotificationChannel(
            DB_CHANNEL_ID, DB_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(dbChannel)
    }

    private fun showNotification() {
        notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationBuilder = NotificationCompat.Builder(this, DB_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(TITLE_DB_NOTIFICATION)
            .setProgress(0, 0, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationBuilder.setColor(getColor(R.color.colorPrimary)).setColorized(true)
        }
        notificationManagerCompat.notify(DB_NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun finishProcessNotification(msg: String) {
        notificationBuilder.setContentText(msg)
            .setProgress(0, 0, false)
        notificationManagerCompat.notify(DB_NOTIFICATION_ID, notificationBuilder.build())
    }

    companion object {

        private const val DB_ZIP_NAME = "databases.zip"
        private const val DB_NOTIFICATION_ID = 1
        private const val DB_CHANNEL_ID = "db_channel_id"
        private const val DB_CHANNEL_NAME = "db_channel_name"
        private const val TITLE_DB_NOTIFICATION = "Extra database"
        private const val CONTENT_FINISH_EXTRA_DB = "Extra complete"
    }
}