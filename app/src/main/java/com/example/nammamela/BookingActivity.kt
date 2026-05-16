package com.example.nammamela

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nammamela.data.AppDatabase
import com.example.nammamela.data.Seat
import com.example.nammamela.databinding.ActivityBookingBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding
    private lateinit var database: AppDatabase
    private lateinit var adapter: SeatAdapter
    private var selectedSeat: Seat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getDatabase(this)
        setupRecyclerView()
        observeSeats()

        binding.btnConfirmBooking.setOnClickListener {
            reserveSelectedSeat()
        }
    }

    private fun setupRecyclerView() {
        adapter = SeatAdapter { seat ->
            selectedSeat = seat
            Toast.makeText(this, "Selected Seat: ${seat.row}${seat.number}", Toast.LENGTH_SHORT).show()
        }
        binding.rvSeats.layoutManager = GridLayoutManager(this, 5)
        binding.rvSeats.adapter = adapter
    }

    private fun observeSeats() {
        lifecycleScope.launch {
            database.seatDao().getAllSeats().collect { seats ->
                if (seats.isEmpty()) {
                    seedDatabase()
                } else {
                    adapter.submitList(seats)
                }
            }
        }
    }

    private suspend fun seedDatabase() {
        val initialSeats = mutableListOf<Seat>()
        val rows = listOf("A", "B", "C", "D", "E")
        var id = 1
        for (row in rows) {
            for (num in 1..5) {
                initialSeats.add(Seat(id++, row, num))
            }
        }
        database.seatDao().insertAll(initialSeats)
    }

    private fun reserveSelectedSeat() {
        val seat = selectedSeat
        if (seat == null) {
            Toast.makeText(this, "Please select a seat first", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val updatedSeat = seat.copy(isReserved = true)
            database.seatDao().updateSeat(updatedSeat)
            Toast.makeText(this@BookingActivity, "Seat ${seat.row}${seat.number} Reserved!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
