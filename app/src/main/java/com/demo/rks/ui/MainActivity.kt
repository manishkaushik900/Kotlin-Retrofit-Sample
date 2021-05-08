package com.demo.rks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.rks.R
import com.demo.rks.adapter.CustomAdapter
import com.demo.rks.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var listUsers: MutableList<User>
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recylerview_main) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        listUsers = mutableListOf<User>()

        adapter = CustomAdapter(listUsers)

        recyclerView.adapter = adapter

        val userViewModel =
            ViewModelProviders.of(this, UserViewModelFactory(application)).get(UserViewModel::class.java)

        userViewModel.getData().observe(this, object : Observer<ArrayList<User>> {
            override fun onChanged(t: ArrayList<User>?) {
                listUsers.clear()
                t?.let {
                    listUsers.addAll(it)
                }
                adapter.notifyDataSetChanged()
            }

        })
    }
}