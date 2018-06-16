package com.developer.fabian.tipcalckotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developer.fabian.tipcalckotlin.R
import com.developer.fabian.tipcalckotlin.adapter.IOnItemClickListener
import com.developer.fabian.tipcalckotlin.model.TipRecord

class TipHistoryListFragment : Fragment(), IListFragmentListener, IOnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_tip_history_list, container, false)

        initAdapter()
        initRecyclerView()

        return view
    }

    override fun addToList(record: TipRecord) {

    }

    override fun clearList() {

    }

    override fun onItemClick(tipRecord: TipRecord) {

    }

    private fun initAdapter() {

    }

    private fun initRecyclerView() {

    }
}
