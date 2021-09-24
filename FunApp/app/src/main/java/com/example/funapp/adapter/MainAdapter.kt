package com.example.funapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.funapp.BR
import com.example.funapp.R
import com.example.funapp.data.LayoutGridData
import com.example.funapp.databinding.ItemMainLayoutBinding

/**
 * X1abei
 * 2021/9/23
 */
class MainAdapter(
    private val data: ArrayList<LayoutGridData>,
    private val gridLayoutManager: GridLayoutManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var itemClickListener: (position: Int) -> Unit = {}
    fun setOnItemClickListener(e: (position: Int) -> Unit) {
        this.itemClickListener = e
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_main_layout,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MainViewHolder).binding
        binding.setVariable(BR.homeData, data[position])
        val params = binding.root.layoutParams
        params.height = gridLayoutManager.width / gridLayoutManager.spanCount
        binding.root.layoutParams = params
        binding.root.setOnClickListener {
            itemClickListener(position)
        }
    }

    override fun getItemCount(): Int = data.size

    class MainViewHolder(dataBinding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        val binding = dataBinding
    }
}