package com.rabarka.lazyverticalgridexample

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cat(
    @DrawableRes val imageResId: Int,
    @StringRes val stringResId: Int
)
