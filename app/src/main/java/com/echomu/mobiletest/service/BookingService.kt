package com.echomu.mobiletest.service

import android.content.Context
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.StringUtils
import com.echomu.mobiletest.bean.Booking
import com.echomu.mobiletest.manager.DataManager
import com.echomu.mobiletest.util.CommentUtil

/**
 * @author echoMu
 * @date 2024/9/20
 * @desc booking data service
 */
object BookingService {

    fun requestBookingData(): Booking? {
        //Use the supplied.json file mock response
        val json = CommentUtil.getAssetsStingByName("booking.json")
        if (!StringUtils.isEmpty(json)) {
            return GsonUtils.fromJson(json, Booking::class.java)
        }
        return null
    }

}