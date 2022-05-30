package com.bontouch.example.compose.domain

import androidx.annotation.DrawableRes
import org.threeten.bp.LocalDate

data class Teams(
    val studios: List<Studio> = emptyList()
)

data class Studio(
    val name: String?,
    @DrawableRes val logoResource: Int?,
    val employees: List<Employee>
)

data class Employee(
    val name: String,
    val role: String,
    val team: String?,
    val notes: String,
    val startDate: LocalDate,
    @DrawableRes val imageResource: Int
)
