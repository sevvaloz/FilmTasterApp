package com.ozdamarsevval.upschoolhomework1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EntireInfo(
    val userInfo: UserInfo,
    val favFilmInfo: FavFilmInfo
): Parcelable
