package com.example.mohammad.myschool_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_student.*

class StudentAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        var url: String = Web_info.based_Url + "bus_students_get.php"

        var studentlist = ArrayList<String>()

        var rq = Volley.newRequestQueue(this)

        var sr = JsonArrayRequest(Request.Method.GET, url,
                null, Response.Listener { response ->

            for (x in 0..response.length() - 1) {
                studentlist.add(response.getJSONObject(x).getString("bus_name") + "\n" +
                        response.getJSONObject(x).getString("st_name"))
            }

            var adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentlist)
            student_lv.adapter = adp
        },
                Response.ErrorListener { error -> }
        )

        rq.add(sr)
    }
}
