package com.app.submissionakhir.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club (
    val name: String,
    val desc: String,
    val stadium: String,
    val epl: String,
    val ucl: String,
    val fa: String,
    val poto: Int
): Parcelable
