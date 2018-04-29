package com.example.mohammad.myschool_app

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_test.*
import android.content.Intent


class TestActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        bnv.setOnNavigationItemSelectedListener { item ->
            when {
                item.itemId == R.id.bus -> {
                    val intent = Intent(this, TestActivity::class.java)
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
