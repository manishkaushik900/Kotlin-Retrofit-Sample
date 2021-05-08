package com.demo.rks.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.demo.rks.model.User
import com.demo.rks.repository.UserRepository
import com.demo.rks.utils.Utility.isInternetAvailable

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var listData = MutableLiveData<ArrayList<User>>()

    init {
        val userRepository: UserRepository by lazy { UserRepository }

        if (application.isInternetAvailable()) {
            listData = userRepository.getMutubaleLiveData(application)
        }

    }

    fun getData(): MutableLiveData<ArrayList<User>> = listData

}