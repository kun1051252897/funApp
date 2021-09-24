package com.example.funapp.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * X1abei
 * 2021/9/23
 */
class ImageExt {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun imgUrl(view: ImageView, url: String?) {
            Glide.with(view)
                .load(url)
                .into(view)
        }

        @BindingAdapter("imageId")
        @JvmStatic
        fun imgId(view: ImageView, @DrawableRes id: Int?) {
            Glide.with(view)
                .load(id)
                .into(view)
        }
    }
}