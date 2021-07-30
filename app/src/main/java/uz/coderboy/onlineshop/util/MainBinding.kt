package uz.coderboy.onlineshop.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import uz.coderboy.onlineshop.R

class BindingLayout{
    companion object{


        @BindingAdapter("android:imageFromUrl")
        @JvmStatic
        fun imageFromUrl(view: ImageView, url: String){
            Picasso.get().load(url).placeholder(R.drawable.ic_person).into(view)
        }
    }
}