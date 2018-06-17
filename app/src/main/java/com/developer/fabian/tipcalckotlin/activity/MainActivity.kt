package com.developer.fabian.tipcalckotlin.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.developer.fabian.tipcalckotlin.R
import com.developer.fabian.tipcalckotlin.TipCalcApplication
import com.developer.fabian.tipcalckotlin.fragment.IListFragmentListener
import com.developer.fabian.tipcalckotlin.fragment.TipHistoryListFragment
import com.developer.fabian.tipcalckotlin.model.TipRecord
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TIP_STEP_CHANGE: Int = 1
        private const val DEFAULT_TIP_PERCENTAGE: Double = 10.0
    }

    @BindView(R.id.inputBill)
    lateinit var inputBill: EditText

    @BindView(R.id.inputPercentage)
    lateinit var inputPercentage: EditText

    @BindView(R.id.txtTip)
    lateinit var txtTip: TextView

    private var fragmentListener: IListFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val fragment: TipHistoryListFragment = supportFragmentManager.findFragmentById(R.id.fragmentList) as TipHistoryListFragment

        fragment.retainInstance = true
        fragmentListener = fragment
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.action_about)
            about()

        return super.onOptionsItemSelected(item)
    }

    @OnClick(R.id.btnSubmit)
    internal fun handleClickSubmit() {
        hideKeyBoard()

        val strInputTotal = inputBill.text.toString().trim()

        if (!strInputTotal.isEmpty()) {
            val total: Double = strInputTotal.toDouble()
            val tipPercent = getTipPercent()

            val tipRecord = TipRecord()

            tipRecord.bill = total
            tipRecord.tipPercentage = tipPercent
            tipRecord.timestamp = Date()

            val strTip: String = String.format(getString(R.string.global_message_tip), tipRecord.getTip())
            fragmentListener!!.addToList(tipRecord)

            txtTip.visibility = View.VISIBLE
            txtTip.text = strTip
        }
    }

    @OnClick(R.id.btnIncrease)
    internal fun handleClickIncrease() {
        hideKeyBoard()
        handleTipChange(TIP_STEP_CHANGE)
    }

    @OnClick(R.id.btnDecrease)
    internal fun handleClickDecrease() {
        hideKeyBoard()
        handleTipChange(-TIP_STEP_CHANGE)
    }

    @OnClick(R.id.btnClear)
    internal fun handleClickClear() {
        hideKeyBoard()
        fragmentListener!!.clearList()
    }

    private fun handleTipChange(value: Int) {
        var tipPercentage: Double = getTipPercent()
        tipPercentage += value

        if (tipPercentage > 0)
            inputPercentage.text = SpannableStringBuilder(tipPercentage.toString())
    }

    private fun getTipPercent(): Double {
        var tipPercentage: Double = DEFAULT_TIP_PERCENTAGE
        val strInputTipPercentage: String = inputPercentage.text.toString().trim()

        if (!strInputTipPercentage.isEmpty())
            tipPercentage = strInputTipPercentage.toDouble()
        else
            inputPercentage.text = SpannableStringBuilder(tipPercentage.toString())

        return tipPercentage
    }

    private fun hideKeyBoard() {
        val inputManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        try {
            inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch (nullEx: NullPointerException) {
            Log.e(localClassName, Log.getStackTraceString(nullEx))
        }
    }

    private fun about() {
        val app: TipCalcApplication = application as TipCalcApplication
        val url: String = app.getAboutUrl()
        val intent = Intent(Intent.ACTION_VIEW)

        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
