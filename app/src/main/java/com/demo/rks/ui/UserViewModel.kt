package com.demo.rks.ui

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.rks.model.User
import com.demo.rks.repository.UserRepository
import com.demo.rks.utils.Utility.isInternetAvailable

class UserViewModel(private val context: Context): ViewModel() {

    private var listData = MutableLiveData<ArrayList<User>>()

    init {
        val userRepository : UserRepository by lazy { UserRepository }

        if(context.isInternetAvailable()){
            listData = userRepository.getMutubaleLiveData(context)
        }

    }

    fun getData(): MutableLiveData<ArrayList<User>> = listData

}