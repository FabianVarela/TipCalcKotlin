package com.developer.fabian.tipcalckotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.developer.fabian.tipcalckotlin.R

class TipDetailActivity : AppCompatActivity() {

    companion object {
        const val TIP_KEY: String = "tip"
        const val DATE_KEY: String = "timestamp"
        const val BILL_TOTAL_KEY: String = "total"
    }

    @BindView(R.id.txtBillTotal)
    lateinit var txtBillTotal: TextView

    @BindView(R.id.txtTip)
    lateinit var txtTip: TextView

    @BindView(R.id.txtTimeStamp)
    lateinit var txtTimeStamp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tip_detail)
        ButterKnife.bind(this)

        val intent = intent

        val strTotal: String = String.format(getString(R.string.tip_detail_message_bill), intent.getDoubleExtra(BILL_TOTAL_KEY, 0.0))
        val strTip: String = String.format(getString(R.string.global_message_tip), intent.getDoubleExtra(TIP_KEY, 0.0))

        txtBillTotal.text = strTotal
        txtTip.text = strTip
        txtTimeStamp.text = intent.getStringExtra(DATE_KEY)
    }
}
