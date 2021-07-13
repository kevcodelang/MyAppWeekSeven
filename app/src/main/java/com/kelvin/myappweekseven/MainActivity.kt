package com.kelvin.myappweekseven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelvin.myappweekseven.databinding.ActivityMainBinding
import com.kelvin.myappweekseven.models.User
import com.kelvin.myappweekseven.ui.MainViewModel
import com.kelvin.myappweekseven.ui.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter=  UserAdapter((listOf()))
        viewModel=ViewModelProvider(this)[MainViewModel::class.java]

        binding.userRV.apply {
            adapter=userAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.run{
            getUsers()
            usersLiveData.observe(this@MainActivity, {
                userAdapter.users=users
                userAdapter.notifyDataSetChanged()
            })

        }
    }
}