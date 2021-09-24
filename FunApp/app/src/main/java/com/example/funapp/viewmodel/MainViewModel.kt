package com.example.funapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.funapp.R
import com.example.funapp.data.LayoutGridData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * X1abei
 * 2021/9/22
 */
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val homeDataList = arrayListOf<LayoutGridData>()

    init {
        homeDataList.add(LayoutGridData(R.drawable.ic_constellation, "星座查询"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
        homeDataList.add(LayoutGridData(R.drawable.ic_weather_forecast, "天气预报"))
    }
}