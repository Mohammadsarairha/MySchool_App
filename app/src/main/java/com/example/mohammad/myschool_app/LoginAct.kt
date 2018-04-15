package com.example.mohammad.myschool_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

            var url:String=Web_info.based_Url+"user_type_select.php?"+"user_phone="+login_phone.text.toString()

            var rq= Volley.newRequestQueue(this)

            var sr= StringRequest(Request.Method.GET,url,
                    Response.Listener { response ->
                        when(response){
                            "0"-> {
                                var i = Intent(this, MapsAct::class.java)
                                startActivity(i)
                            }
                            "1"->{
                                var i = Intent(this, StudentAct::class.java)
                                startActivity(i)
                            }
                            "2"->{
                                var i = Intent(this, MapsAct::class.java)
                                startActivity(i)
                            }
                            else -> Toast.makeText(this,"Enter valid Number",Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener { error ->  })

            rq.add(sr)
    }

}}
