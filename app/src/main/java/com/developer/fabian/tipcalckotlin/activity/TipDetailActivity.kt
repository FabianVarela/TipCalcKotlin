package com.developer.fabian.tipcalckotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.developer.fabian.tipcalckotlin.R

class TipDetailActivity : AppCompatActivity() {

    companion object {
        const val TIP_KEY: String = "tip"
        const val DATE_KEY: String = "timestamp"
        const val BILL_TOTAL_KEY: String = "total"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_detail)

        val intent = intent

        val strTotal: String = String.format(getString(R.string.tip_detail_message_bill), intent.getDoubleExtra(BILL_TOTAL_KEY, 0.0))
        val strTip: String = String.format(getString(R.string.global_message_tip), intent.getDoubleExtra(TIP_KEY, 0.0))

        /*txtBillTotal.setText(strTotal)
        txtTip.setText(strTip)
        txtTimeStamp.setText(intent.getStringExtra(DATE_KEY))*/
    }
}
