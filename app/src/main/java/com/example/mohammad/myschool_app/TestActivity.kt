package com.example.mohammad.myschool_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        bnv.setOnNavigationItemSelectedListener { item ->
            when {
                item.itemId == R.id.bus -> {
                    val intent = Intent(this, TestMapsActivity::class.java)
                    startActivity(intent)
                }
                item.itemId == R.id.student -> {
                    val intent = Intent(this, Test1Activity::class.java)
                    startActivity(intent)
                }
            }

            item.isChecked = true

            false

        }

    }
}
