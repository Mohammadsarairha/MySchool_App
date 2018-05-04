package com.example.mohammad.myschool_app

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bus.*

class BusActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)

        var locationManager = getSystemService(Context.LOCATION_SERVICE)
                as LocationManager

        var locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                textView1.text = "lat:  ${location?.latitude}"
                textView2.text = "lng:  ${location?.longitude}"
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0.0F, locationListener)
    }
}
