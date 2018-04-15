package com.example.mohammad.myschool_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {

            var url:String=Web_info.based_Url+"user_type_select.php"

            var rq= Volley.newRequestQueue(this)

            var sr=object: StringRequest(Request.Method.GET,url,
                    Response.Listener { response ->
                        if (response=="0"){

                        }
                    },
                    Response.ErrorListener { error ->  })


            rq.add(sr)
    }

}}
