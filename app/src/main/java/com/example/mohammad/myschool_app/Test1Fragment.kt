package com.example.mohammad.myschool_app


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test1.view.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.example.mohammad.myschool_app.R.id.mapView
import com.google.android.gms.maps.CameraUpdateFactory
import sun.awt.windows.ThemeReader.getPosition
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.LatLngBounds




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Test1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_test1, container, false)


        view.mapView.getMapAsync { googleMap -> googleMap.moveCamera() }


        return view
    }

}
