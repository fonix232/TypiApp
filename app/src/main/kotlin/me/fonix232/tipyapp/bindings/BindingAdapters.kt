package me.fonix232.tipyapp.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("android:src")
fun setImageRawData(view: ImageView, data: String?) {
    Glide.with(view.context).load(data).into(view)
}