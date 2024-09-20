package com.echomu.mobiletest.manager

import android.content.Context
import com.blankj.utilcode.util.GsonUtils
import com.echomu.mobiletest.bean.Booking
import com.echomu.mobiletest.service.BookingService

/**
 * @author echoMu
 * @date 2024/9/20
 * @desc booking data provider
 */
class DataManager : DataProvider{

    var lastCheckUpDataTime: Long = 0

    /**
     * Provides a unified external interface to obtain data
     * @param context
     */
    override fun loadData(context: Context): Booking? {
        var bookingBean = PreferenceHelper.loadBookingFromPreferences(context)
        if (bookingBean == null) {
            //First request
            bookingBean = BookingService.requestBookingData()
            PreferenceHelper.saveBookingToPreferences(context, GsonUtils.toJson(bookingBean))
        } else {
            //With local caching, the first thing to do is to return the cache (whether it has expired or not).
            return bookingBean
        }
        checkExpire(context)
        return bookingBean
    }

    private fun checkExpire(context: Context) {
        lastCheckUpDataTime = PreferenceHelper.loadLongFromPreferences(context)
        if (lastCheckUpDataTime == 0L) {
            lastCheckUpDataTime = System.currentTimeMillis()
            PreferenceHelper.saveLongToPreferences(context, lastCheckUpDataTime)
        }
        var currentTime = System.currentTimeMillis()
        val minute = ((currentTime - lastCheckUpDataTime) / 1000) / 60
        //The data expires in 5 minutes.
        if (minute >= 5) {
            //Trigger auto refresh
            val bookingBean = BookingService.requestBookingData()
            //Get a new api response to replace the old data and return the latest data
            PreferenceHelper.saveBookingToPreferences(context, GsonUtils.toJson(bookingBean))
            PreferenceHelper.saveLongToPreferences(context, currentTime)
        }
    }

}