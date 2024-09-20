package com.echomu.mobiletest.manager

import android.content.Context
import com.echomu.mobiletest.bean.Booking

/**
 * @author Crong
 * @date 2024/9/20
 * @desc
 */
interface DataProvider {
    fun loadData(context: Context): Booking?
}