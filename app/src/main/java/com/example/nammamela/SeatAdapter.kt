package com.example.nammamela

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nammamela.data.Seat
import com.example.nammamela.databinding.ItemSeatBinding

class SeatAdapter(private val onSeatClick: (Seat) -> Unit) :
    ListAdapter<Seat, SeatAdapter.SeatViewHolder>(SeatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        val binding = ItemSeatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SeatViewHolder(private val binding: ItemSeatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(seat: Seat) {
            binding.tvSeatNumber.text = "${seat.row}${seat.number}"
            
            if (seat.isReserved) {
                binding.cardSeat.setCardBackgroundColor(Color.parseColor("#444444"))
                binding.root.isEnabled = false
            } else {
                binding.cardSeat.setCardBackgroundColor(Color.parseColor("#B22222"))
                binding.root.isEnabled = true
            }

            binding.root.setOnClickListener {
                if (!seat.isReserved) {
                    onSeatClick(seat)
                }
            }
        }
    }

    class SeatDiffCallback : DiffUtil.ItemCallback<Seat>() {
        override fun areItemsTheSame(oldItem: Seat, newItem: Seat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Seat, newItem: Seat): Boolean {
            return oldItem == newItem
        }
    }
}
