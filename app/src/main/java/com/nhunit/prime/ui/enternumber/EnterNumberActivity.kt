package com.nhunit.prime.ui.enternumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nhunit.prime.R
import kotlinx.android.synthetic.main.activity_enter_number.*

class EnterNumberActivity : AppCompatActivity() {
    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_number)

        checkEvent()
    }

    fun checkEvent() {
        aenBtnCheck.setOnClickListener {
            try {
                number = aenEdtNumberInput.text.toString().toInt()
                if (checkPrime()) {
                    aenTvResult.text = "Đây là số nguyên tố"
                    return@setOnClickListener
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            aenTvResult.text = "Đây không phải là số nguyên tố"
        }
    }

    fun checkPrime(): Boolean {
        if (number <= 0)
            return false

        for (i in 2..number / 2) {
            // condition for nonprime number
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}