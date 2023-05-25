package com.mhdkadi.awesome_downloader

import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class HttpClient {
    private var okHttpClient: OkHttpClient= OkHttpClient()

    fun download(){
        val okHttpBuilder = okHttpClient.newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        this.okHttpClient = okHttpBuilder.build()
        val request = Request.Builder().url("").build()
        val response = okHttpClient.newCall(request).execute()
        val body = response.body
        val responseCode = response.code
        if (responseCode >= HttpURLConnection.HTTP_OK &&
            responseCode < HttpURLConnection.HTTP_MULT_CHOICE &&
            body != null) {
            body.byteStream().apply {
                file.outputStream().use { fileOut ->
                    copyTo(fileOut, BUFFER_LENGTH_BYTES)
                }
            }

        } else {
            // Report the error
        }
    }
}