package com.sanmed.searchitems.view.ui.loader

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader {
    companion object{
        fun loadInto(imageView: ImageView,url:String?,placeholder: Drawable){
            Picasso.get().load(url).error(placeholder).into(imageView)
        }
    }
}