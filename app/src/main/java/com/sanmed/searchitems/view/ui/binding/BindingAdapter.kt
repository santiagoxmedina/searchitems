package com.sanmed.searchitems.view.ui.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sanmed.searchitems.view.ui.loader.ImageLoader

object BindingAdapter {

        @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
        @JvmStatic fun loadImage(imageView: ImageView, url: String?, placeholder: Drawable) {
            if (url == null || url.isEmpty()) {
                imageView.setImageDrawable(placeholder);
            } else {
                ImageLoader.loadInto(imageView, url, placeholder);
            }
        }

}