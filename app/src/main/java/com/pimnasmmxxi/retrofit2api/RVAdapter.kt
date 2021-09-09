package com.pimnasmmxxi.retrofit2api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pimnasmmxxi.retrofit2api.databinding.CellBinding


class RVAdapter(private val cell: ArrayList<Cell>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CellViewHolder(var viewBinding: CellBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as CellViewHolder
        itemViewHolder.viewBinding.fcName.text = cell[position].fcName
        itemViewHolder.viewBinding.fcFacts.text = cell[position].fcFacts
        itemViewHolder.viewBinding.fcImages.text = cell[position].fcImages
        itemViewHolder.viewBinding.allergyof.text = cell[position].allergyof
        itemViewHolder.viewBinding.groupof.text = cell[position].groupof

    }

    override fun getItemCount(): Int {
        return cell.size
    }
}