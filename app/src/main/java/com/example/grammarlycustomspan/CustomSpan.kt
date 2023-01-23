package com.example.grammarlycustomspan

import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt

class CustomSpan(
    @ColorInt
    val color: Int,
    val data: CustomData
) : ForegroundColorSpan(color)