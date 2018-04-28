package com.example.mohammad.myschool_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Test1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        val tr = fragmentManager.beginTransaction()
        val obj = MapTestFragment()
        tr.replace(R.id.fragmentContainer, obj).addToBackStack(Test1Fragment().tag).commit()
    }
}
