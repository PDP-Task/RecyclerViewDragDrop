package com.sdk.recyclerviewdragdrop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdk.recyclerviewdragdrop.adapter.UserAdapter
import com.sdk.recyclerviewdragdrop.adapter.itemTouchHelper
import com.sdk.recyclerviewdragdrop.databinding.ActivityMainBinding
import com.sdk.recyclerviewdragdrop.util.ObjectList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter()
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
        userAdapter.differ.submitList(ObjectList.userList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = userAdapter
    }
}
