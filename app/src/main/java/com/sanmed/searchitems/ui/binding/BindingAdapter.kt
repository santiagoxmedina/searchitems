package com.sanmed.searchitems.ui.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sanmed.searchitems.ui.loader.ImageLoader

object BindingAdapter {

        @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
        @JvmStatic fun loadImage(imageView: ImageView, url: String?, placeholder: Drawable) {
            if (url == null) {
                imageView.setImageDrawable(placeholder);
            } else {
                ImageLoader.loadInto(imageView, url, placeholder);
            }
        }

}