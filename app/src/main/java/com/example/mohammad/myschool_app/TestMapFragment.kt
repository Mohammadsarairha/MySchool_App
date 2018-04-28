package com.example.mohammad.myschool_app


import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_test_maps.*
import kotlinx.android.synthetic.main.fragment_map_test.*
import kotlinx.android.synthetic.main.fragment_map_test.view.*
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.common.GooglePlayServicesNotAvailableException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MapTestFragment : Fragment(), OnMapReadyCallback {

    val map: GoogleMap? = null

    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onMapReady(p0: GoogleMap?) {
        val mMap = p0

        val jordan = LatLng(30.5852, 36.2384)
        mMap?.addMarker(MarkerOptions().position(jordan).title("Marker in Jordan"))
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(jordan))

        mMap?.isMyLocationEnabled = true
    }

    @SuppressLint("MissingPermission")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map_test, container, false)

        view.mapView.onCreate(savedInstanceState)
        view.mapView.getMapAsync(this)

        map?.uiSettings?.isMyLocationButtonEnabled = false
        map?.isMyLocationEnabled = true

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this.activity)
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }

        // Updates the location and zoom of the MapView
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(43.1, -87.9), 10f)
        map?.animateCamera(cameraUpdate)

        return view
    }
}
