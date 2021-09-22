package com.example.funapp.net

/**
 * X1abei
 * 2021/8/11
 */
class DataRepository {
    private var service =
        HttpManager.getRetrofit("https://www.wanandroid.com/")?.create(Api::class.java)
    private val goodsService =
        HttpManager.getRetrofit("https://d.gu-global.com")?.create(Api::class.java)


}