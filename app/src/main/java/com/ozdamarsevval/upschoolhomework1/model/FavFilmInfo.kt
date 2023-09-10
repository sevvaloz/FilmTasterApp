package com.ozdamarsevval.upschoolhomework1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavFilmInfo(
    val favFilmName: String,
    val favFilmName2: String,
    val favFilmName3: String,
    val horrorGenre: Boolean,
    val dramaGenre: Boolean,
    val romanticGenre: Boolean,
    val actionGenre: Boolean,
    val scifiGenre: Boolean
): Parcelable
