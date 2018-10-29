package com.sournary.awesomeenglish.util

import android.content.Context
import android.util.Log
import java.io.*
import java.util.zip.ZipInputStream

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
fun Context.extractDbZipFile(
    dbName: String,
    onExtraBeginning: (() -> Unit)? = null,
    onSuccess: (() -> Unit)? = null,
    onFailed: ((String) -> Unit)? = null
) {
    // Return /data/user/0 + your_package_name + /database/
    val path = getDatabasePath("a").parentFile.path
    try {
        val inputStream = assets.open(dbName)
        val zipInputStream = ZipInputStream(BufferedInputStream(inputStream))
        var zipEntry = zipInputStream.nextEntry
        onExtraBeginning?.invoke()
        while (zipEntry != null) {
            if (!zipEntry.isDirectory) {
                val files = zipEntry.name.split(File.separator)
                val fileName = files[files.size - 1]
                Log.d("DbManagerService", "zipEntry: $fileName")
                val file = File(path, fileName)
                val fileOutputStream = FileOutputStream(file)
                val bufferOutputStream = BufferedOutputStream(fileOutputStream)
                val buffer = ByteArray(1024)
                var length = zipInputStream.read(buffer)
                while (length > 0) {
                    bufferOutputStream.write(buffer, 0, length)
                    length = zipInputStream.read(buffer)
                }
//                fileOutputStream.close()
//                bufferOutputStream.close()
            }
            zipEntry = zipInputStream.nextEntry
        }
        inputStream.close()
        zipInputStream.close()
        onSuccess?.invoke()
    } catch (e: IOException) {
        onFailed?.invoke(e.message ?: "Unknown error")
    }
}
