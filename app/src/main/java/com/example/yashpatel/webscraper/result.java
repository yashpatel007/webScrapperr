package com.example.yashpatel.webscraper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class result extends AppCompatActivity {

    TextView tv;

    String url,tag1,tag2,tag3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=findViewById(R.id.tv);

        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("passed_url");
        tag1 = bundle.getString("passed_tag1");
        tag2 = bundle.getString("passed_tag2");

        // setting the entered fields as url
        tv.append("url  : "+url+"\n");
        tv.append("tag1 :"+tag1+"\n");
        tv.append("tag2 :"+tag2+"\n");


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // when the request in queue executes succesfully
                Toast.makeText(result.this, "Request Successful", Toast.LENGTH_SHORT).show();
                //tv.append(response);
                Document doc = Jsoup.parse(response);

                // getting the first element by tag
                if(tag1.length()!=0&&tag2.length()!=0) {
                    Elements itemElements = doc.getElementsByTag(tag1);

                    for (int i = 0; i < itemElements.size(); i++) {
                        Element item = itemElements.get(i);
                        String title = item.getElementsByTag(tag2).text();
                        Log.i("mytag", title);
                        tv.append(title);
                        tv.append("\n");
                    }

                    Toast.makeText(result.this, "items found : "+itemElements.size(), Toast.LENGTH_LONG).show();
                }//if statement ends
               else if(tag1.length()==0){
                    Toast.makeText(result.this,"tag1 is empty: please enter something",Toast.LENGTH_LONG).show();
                }
                else if(tag2.length()==0){
                    Toast.makeText(result.this,"tag2 is empty",Toast.LENGTH_LONG).show();

                    Elements itemElements = doc.getElementsByTag(tag1);

                    for (int i = 0; i < itemElements.size(); i++) {
                        Element item = itemElements.get(i);
                        //String title = item.getElementsByTag(tag2).text();
                        Log.i("mytag", (item).text());
                        tv.append(item.text());
                        tv.append("\n");
                    }

                    Toast.makeText(result.this, "items found : "+itemElements.size(), Toast.LENGTH_LONG).show();

                }// elif ends if the tag2 is empty



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // when  an errror happens with the queue request
                Toast.makeText(result.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });

        // adding the request to queue
        Toast.makeText(result.this, "Request Sent. please wait", Toast.LENGTH_SHORT).show();
        queue.add(request);



    }
}
