package com.developer.fabian.tipcalckotlin.adapter

import com.developer.fabian.tipcalckotlin.model.TipRecord

interface IOnItemClickListener {
    fun onItemClick(tipRecord: TipRecord)
}
