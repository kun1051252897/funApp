package com.example.funapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.funapp.R
import com.example.funapp.databinding.ActivityMainBinding
import com.example.funapp.adapter.MainAdapter
import com.example.funapp.view.itemdecoration.GridItemDecoration
import com.example.funapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainRv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter =
                MainAdapter(viewModel.homeDataList, layoutManager as GridLayoutManager)
            (adapter as MainAdapter).setOnItemClickListener {
                nav(it)
            }
            addItemDecoration(GridItemDecoration())
        }
    }

    private fun nav(position: Int) {
        val intent = Intent()
        when (position) {
            0 -> {
                intent.setClass(this,ConstellationActivity::class.java)
            }
            else -> {
            }
        }
        startActivity(intent)
    }
}