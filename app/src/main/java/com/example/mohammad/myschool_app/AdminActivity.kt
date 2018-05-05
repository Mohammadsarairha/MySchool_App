package com.example.mohammad.myschool_app

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_admin.*
import android.graphics.drawable.Drawable


class AdminActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        bnv.setOnNavigationItemSelectedListener { item ->
            when {
                item.itemId == R.id.bus -> {
                    val intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                }
                item.itemId == R.id.student -> {
                    val intent = Intent(this, StudentAct::class.java)
                    startActivity(intent)
                }
            }

            item.isChecked = true

            false

        }

        // Write a message to the database lat value
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("buses")

        // Read from the database the bus location
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val lat = dataSnapshot.child("bus1").child("lat").value
                        .toString().toDouble()
                val lang = dataSnapshot.child("bus1").child("lng").value
                        .toString().toDouble()

                // Add a marker in bus location and move the camera
                val bus = LatLng(lat, lang)
                mMap.addMarker(MarkerOptions().position(bus).title("bus location"))

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bus, 17.0f))
            }

            override fun onCancelled(error: DatabaseError) {
                /*// Failed to read value
                Log.w(FragmentActivity.TAG, "Failed to read value.", error.toException())*/
            }
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val amman = LatLng(31.944866, 35.929067)
        mMap.addMarker(MarkerOptions().position(amman).title("Marker in amman"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(amman, 17.0f))
    }
}
