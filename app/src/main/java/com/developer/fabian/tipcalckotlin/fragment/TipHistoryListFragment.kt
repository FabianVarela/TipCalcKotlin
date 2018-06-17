package com.developer.fabian.tipcalckotlin.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.developer.fabian.tipcalckotlin.R
import com.developer.fabian.tipcalckotlin.activity.TipDetailActivity
import com.developer.fabian.tipcalckotlin.adapter.IOnItemClickListener
import com.developer.fabian.tipcalckotlin.adapter.TipAdapter
import com.developer.fabian.tipcalckotlin.model.TipRecord

class TipHistoryListFragment : Fragment(), IListFragmentListener, IOnItemClickListener {

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    private var tipAdapter: TipAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_tip_history_list, container, false)

        ButterKnife.bind(this, view)

        initAdapter()
        initRecycler()

        return view
    }

    override fun addToList(record: TipRecord) = tipAdapter!!.add(record)

    override fun clearList() = tipAdapter!!.clear()

    override fun onItemClick(tipRecord: TipRecord) {
        val intent = Intent(activity, TipDetailActivity::class.java)

        intent.putExtra(TipDetailActivity.TIP_KEY, tipRecord.getTip())
        intent.putExtra(TipDetailActivity.BILL_TOTAL_KEY, tipRecord.bill)
        intent.putExtra(TipDetailActivity.DATE_KEY, tipRecord.getDateFormatted())

        startActivity(intent)
    }

    private fun initAdapter() {
        if (tipAdapter == null)
            tipAdapter = TipAdapter(activity!!.applicationContext, mutableListOf(), this)
    }

    private fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = tipAdapter
    }
}
