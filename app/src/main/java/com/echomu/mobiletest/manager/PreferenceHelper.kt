package com.echomu.mobiletest.manager

import android.content.Context
import android.content.SharedPreferences
import com.blankj.utilcode.util.GsonUtils
import com.echomu.mobiletest.bean.Booking

/**
 * @author echoMu
 * @date 2024/9/20
 * @desc Local Persistent Cache Layer
 */
object PreferenceHelper {
    private const val BOOKING_PREF = "BookingPrefs"
    private const val BOOKING_KEY = "booking"
    private const val STRING_KEY = "string"

    fun saveBookingToPreferences(context: Context, json: String) {
        val sharedPreferences = context.getSharedPreferences(BOOKING_PREF, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(BOOKING_KEY, json)
        editor.apply()
    }

    fun loadBookingFromPreferences(context: Context): Booking? {
        val sharedPreferences = context.getSharedPreferences(BOOKING_PREF, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(BOOKING_KEY, "")
        return GsonUtils.fromJson(json, Booking::class.java)
    }

    fun saveLongToPreferences(context: Context, value: Long) {
        val sharedPreferences = context.getSharedPreferences(BOOKING_PREF, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong(STRING_KEY, value)
        editor.apply()
    }

    fun loadLongFromPreferences(context: Context): Long {
        val sharedPreferences = context.getSharedPreferences(BOOKING_PREF, Context.MODE_PRIVATE)
        val value = sharedPreferences.getLong(STRING_KEY, 0)
        return value
    }

}