package com.echomu.mobiletest.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.blankj.utilcode.util.LogUtils
import com.echomu.mobiletest.databinding.ActivityMainBinding
import com.echomu.mobiletest.manager.DataManager
import com.echomu.mobiletest.manager.DataProvider
import com.echomu.mobiletest.service.BookingService

/**
 * @author echoMu
 * @date 2024/9/20
 * @desc blank demo page
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

    }

    override fun onResume() {
        super.onResume()
        loadBookingData()
    }

    private fun loadBookingData() {
        //Each time the page appears, call the data provider interface and print out the corresponding data on the console.
        val dataManager = DataManager()
        val bookingBean = dataManager.loadData(this)
        LogUtils.e("load booking data -> ${bookingBean.toString()}")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false
    }

}