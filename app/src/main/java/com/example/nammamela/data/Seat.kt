package com.example.nammamela.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seats")
data class Seat(
    @PrimaryKey val id: Int,
    val row: String,
    val number: Int,
    val isReserved: Boolean = false
)
