package com.example.funapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * X1abei
 * 2021/9/7
 */
class DataBindingAdapter<T>(
    private var data: List<T>,
    private val variableId: Int,
    private val layoutId: Int
) :
    RecyclerView.Adapter<DataBindingAdapter<T>.DataBindingViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return DataBindingViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: DataBindingViewHolder, position: Int) {
        holder.setContent(data[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<T>){
        this.data = data
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    inner class DataBindingViewHolder(var dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun setContent(t: T) {
            dataBinding.setVariable(variableId, t)
            dataBinding.executePendingBindings()
        }
    }
}