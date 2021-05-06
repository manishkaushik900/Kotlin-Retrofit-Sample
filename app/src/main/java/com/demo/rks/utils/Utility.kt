package com.demo.rks.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object Utility {

    fun Context.isInternetAvailable(): Boolean {
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnected) {
                true
            } else {
                showErrorToast("Internet not available. Please try again!!")
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun Context.showErrorToast(message: String?) {

        try {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}