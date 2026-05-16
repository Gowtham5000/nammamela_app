package com.example.nammamela.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SeatDao {
    @Query("SELECT * FROM seats ORDER BY id ASC")
    fun getAllSeats(): Flow<List<Seat>>

    @Update
    suspend fun updateSeat(seat: Seat)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(seats: List<Seat>)
}
