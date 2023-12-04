package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class video (

    val photo: Int,
    val name: String,
    val description: String,
    val videoId:Int

):Parcelable

