package com.demo.rks.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.demo.rks.api.ApiClient
import com.demo.rks.model.User
import com.demo.rks.utils.Utility.showErrorToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepository {

    fun getMutubaleLiveData(context: Application): MutableLiveData<ArrayList<User>> {

        val mutableLiveData = MutableLiveData<ArrayList<User>>()

        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                val usersResponse = response.body()
                usersResponse?.let {
                    mutableLiveData.value = it as ArrayList<User>
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                context.showErrorToast(t.message)
            }

        }

        )
        return mutableLiveData
    }
}