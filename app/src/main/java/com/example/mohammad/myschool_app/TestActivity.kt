package com.example.mohammad.myschool_app

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TestActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val tr = fragmentManager.beginTransaction()
        val obj = Test1Fragment()
        tr.replace(R.id.fragmentContainer, obj).addToBackStack(Test1Fragment().tag).commit()
    }
}
