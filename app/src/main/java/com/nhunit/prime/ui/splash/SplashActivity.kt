package com.nhunit.prime.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nhunit.prime.R
import com.nhunit.prime.ui.enternumber.EnterNumberActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        goToEnterNumberActivity()
    }

    private fun goToEnterNumberActivity() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //Tạo thể hiện chuyển đổi ngữ cảnh sang màn hình Bluetooth
                val intent = Intent(this@SplashActivity, EnterNumberActivity::class.java)
                //Bắt đầu activity mới
                startActivity(intent)
                //Kết thúc activity hiện tại
                finish()
            }
        }, 1000)
    }
}