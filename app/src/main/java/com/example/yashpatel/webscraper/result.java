package com.example.yashpatel.webscraper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView tv;

    String url,tag1,tag2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=findViewById(R.id.tv);

        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("passed_url");
        tag1 = bundle.getString("passed_tag1");
        tag2 = bundle.getString("passed_tag2");

        tv.setText(url+tag1+tag2);


    }
}
