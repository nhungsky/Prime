package com.nhunit.prime

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.nhunit.prime.ui.enternumber.EnterNumberActivity
import com.robotium.solo.Solo
import org.junit.*
import org.junit.runner.RunWith
import kotlin.random.Random


@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class PrimeTest {

    @Rule
    @JvmField
    public var activityTestRule: ActivityTestRule<EnterNumberActivity> = ActivityTestRule(
        EnterNumberActivity::class.java
    )

    var context: Context? = null
    var solo: Solo? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        solo = Solo(InstrumentationRegistry.getInstrumentation(), activityTestRule.getActivity())
        context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo!!.finishOpenedActivities()
    }

    fun clear() {
        // Xóa dữ liệu có sẵn trong ô
        solo!!.clearEditText(0)
    }

    @Test
    fun testPrime1() {
        for (i in 1..5) {
            // Xóa dữ liệu cũ
            clear()

            // Tạo ngẫu nhiên một số
            val number = Random.nextInt(100)

            // Nhập số nào vô text
            solo!!.enterText(0, number.toString())

            //Nhấn nút kiểm tra số mới nhập
            solo!!.clickOnButton(0)
        }
    }

    @Test
    fun testPrime2() {
            clear()

            // Kiểm tra nhập số âm
            // Tạo ngẫu nhiên một số
            val number = (Random.nextInt(30) - 40)

            // Nhập số nào text
            solo!!.enterText(0, number.toString())

            //Nhấn nút kiểm tra số mới nhập
            solo!!.clickOnButton(0)
            Assert.assertTrue(solo!!.searchText("Đây không phải là số nguyên tố"))

    }

    @Test
    fun testPrime3() {

        clear()

        // Kiểm tra nhập số thập phân
        // Tạo ngẫu nhiên một số
        val number = (Random.nextInt(1, 30) / 3).toDouble()

        // Nhập số nào text
        solo!!.enterText(0, number.toString())

        //Nhấn nút kiểm tra số mới nhập
        solo!!.clickOnButton(0)
        Assert.assertTrue(solo!!.searchText("Đây không phải là số nguyên tố"))

    }

    @Test
    fun testPrime4() {

        clear()
        //Kiểm tra nhập chữ
        //Tạo ngẫu nhiên một chữ
        var s = arrayListOf("gdad", "njhjdha", "chào buổi sáng")

        //Nhập chữ vào text
        solo!!.enterText(0, s.random())

        //Nhấn nút kiểm tra chữ mới nhập
        solo!!.clickOnButton(0)
        Assert.assertTrue(solo!!.searchText("Đây không phải là số nguyên tố"))
    }

    @Test
    fun testPrime5() {

        clear()
        //Kiểm tra nhập dãy số dài
        //Tạo ngẫu nhiên một số
        val number = Random.nextLong(3000000000, 4000000000)

        //Nhập số vào text
        solo!!.enterText(0, number.toString())

        //Nhấn nút kiểm tra số mới nhập
        solo!!.clickOnButton(0)
        Assert.assertTrue(solo!!.searchText("Đây không phải là số nguyên tố"))
    }
}