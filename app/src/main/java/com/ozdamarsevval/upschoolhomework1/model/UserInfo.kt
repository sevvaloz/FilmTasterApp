package com.ozdamarsevval.upschoolhomework1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val nameSurname: String,
    val email: String,
    val phoneNumber: String
): Parcelable
