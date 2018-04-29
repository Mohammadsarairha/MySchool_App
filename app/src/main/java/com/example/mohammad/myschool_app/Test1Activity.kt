package com.example.mohammad.myschool_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test1.*

class Test1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        bnv.setOnNavigationItemSelectedListener { item ->
            when {
                item.itemId == R.id.student -> {
                    val intent = Intent(this, Test1Activity::class.java)
                    startActivity(intent)
                }
                item.itemId == R.id.bus -> {
                    val intent = Intent(this, TestActivity::class.java)
                    startActivity(intent)
                }
            }

            item.isChecked = true

            false

        }

/*
        bnv.selectedItemId = R.id.student
*/
    }
}
