package com.example.class251json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {


    ListView listView;

    TextView textView,tittle2;

    ProgressBar progressBar;


    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();

    HashMap<String,String>hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        listView=findViewById(R.id.listView);






        progressBar=findViewById(R.id.progressBar);


        progressBar.setVisibility(View.VISIBLE);




        Myadapter myadapter=new Myadapter();

        listView.setAdapter(myadapter);














        String url="https://sowrovnil5bd.000webhostapp.com/apps/video.json";


        JsonArrayRequest arrayRequest =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    Log.d("s",response.toString());

                    progressBar.setVisibility(View.GONE);


                    for (int x=0; x<response.length();x++){

                        JSONObject jsonObject=response.getJSONObject(x);

                        String name=jsonObject.getString("name");
                        String video_id=jsonObject.getString("video_id");

                        hashMap=new HashMap<>();
                        hashMap.put("name",name);
                        hashMap.put("video_id",video_id);
                        arrayList.add(hashMap);









                    }






                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {




            }
        });


        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(arrayRequest);

















    }



    //////// adapter class


    public class Myadapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater=getLayoutInflater();

         View Myview=   layoutInflater.inflate(R.layout.layout,parent,false);

        ImageView image1=Myview.findViewById(R.id.image1);
         TextView tittle=Myview.findViewById(R.id.tittle);


         HashMap<String,String>hashMap=arrayList.get(position);

         String name=hashMap.get("name");

         String video_id=hashMap.get("video_id");

         tittle.setText(name);


         String image_url="https://img.youtube.com/vi/"+video_id+"/0.jpg";

            Picasso.get().load(image_url)

                    .into(image1);













            return Myview;
        }
    }







}