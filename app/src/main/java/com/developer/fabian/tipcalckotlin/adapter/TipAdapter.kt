package com.developer.fabian.tipcalckotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developer.fabian.tipcalckotlin.R
import com.developer.fabian.tipcalckotlin.model.TipRecord

class TipAdapter(val context: Context, val dataset: List<TipRecord> = listOf(), val listener: IOnItemClickListener)
    : RecyclerView.Adapter<TipAdapter.ViewHolder>() {

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tipRecord: TipRecord) {

        }

        fun setOnItemClickListener(element: TipRecord, onItemClickListener: IOnItemClickListener) {

        }
    }
}
