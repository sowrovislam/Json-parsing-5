package com.example.class251json;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressBar=findViewById(R.id.prog);

        textView=findViewById(R.id.tex);

        progressBar.setVisibility(View.VISIBLE);

        String url="https://sowrovnil5bd.000webhostapp.com/apps/into.json";



        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                progressBar.setVisibility(View.GONE);


                Log.d("serve",response.toString());


                try {
//                    String name =response.getString("name");
//                    textView.setText(name);

//////////////>>>>>>>>>>>>>>>>>>>>>>>>>>

//
//                    {
//
//                        "name":"sowrov",
//                            "mobile":"01783233620",
//                            "email":"sowrovnil5@gmail.com",
//
//                            "video_url":[
//
//                        {
//                            "tittle": "ami  tomkae valo  basi",
//                                "video": "vLeNeAZmZgo&list=RDvLeNeAZmZgo&start_radio=1"
//                        },
//                        {
//
//                            "tittle": "tumi  amr jibon  ar sob kchu",
//                                "video": "vLeNeAZmZgo&list=RDvLeNeAZmZgo&start_radio=1"
//                        }
//                        ]
//                    }


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


















//>>>>>>>>>>>>>>>>>>>>>>

                    JSONArray jsonArray=response.getJSONArray("video_url");

                     JSONObject jsonObject=jsonArray.getJSONObject(0);

                     String tittle=jsonObject.getString("tittle");

                     String video=jsonObject.getString("video");

                     textView.setText(tittle+"\n"+video);



//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>









                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                textView.setText("sss");

            }
        });

        RequestQueue requestQueue=Volley.newRequestQueue(MainActivity3.this);

                    requestQueue.add(jsonObjectRequest);







    }
}