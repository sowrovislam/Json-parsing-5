package com.example.class251json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText edname,edmobile,edemail;
    ProgressBar progressBar;

    AppCompatButton button,button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edname=findViewById(R.id.edname);
        edemail=findViewById(R.id.edemail);
        edmobile=findViewById(R.id.edmobile);

        button=findViewById(R.id.button);
        button1=findViewById(R.id.button1);

        button2=findViewById(R.id.button2);


        progressBar=findViewById(R.id.progressBar);





        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity3.class));



            }
        });







        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });



















        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);





// Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);



                String url = "https://sowrovnil5bd.000webhostapp.com/apps/new.json";

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                progressBar.setVisibility(View.GONE);

                                Log.d("serverRes",response);

                                try {
                                    JSONObject jsonObject=new JSONObject(response);




                                  String name= jsonObject.getString("name");
                                  edname.setText(name);

                                  String mobile=jsonObject.getString("mobile");
                                  edmobile.setText(mobile);
                                  String email=jsonObject.getString("email");
                                  edemail.setText(email);






                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        edname.setText("That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);

















            }
        });



















    }
}