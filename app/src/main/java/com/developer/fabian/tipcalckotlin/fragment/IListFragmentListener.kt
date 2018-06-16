package com.developer.fabian.tipcalckotlin.fragment

import com.developer.fabian.tipcalckotlin.model.TipRecord

interface IListFragmentListener {
    fun addToList(record: TipRecord)
    fun clearList()
}
