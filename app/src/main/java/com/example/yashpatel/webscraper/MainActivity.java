package com.example.yashpatel.webscraper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText url,tag1,tag2;
    String[] searchby = {"Search by tag", "Search by child"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = findViewById(R.id.url);
        tag1 = findViewById(R.id.tag1);
        tag2 = findViewById(R.id.tag2);

        Spinner spintag1 = (Spinner) findViewById(R.id.spintag1);
        spintag1.setOnItemSelectedListener(MainActivity.this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, searchby);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spintag1.setAdapter(aa);


        Spinner spintag2 = (Spinner) findViewById(R.id.spintag2);
        spintag2.setOnItemSelectedListener(MainActivity.this);
        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, searchby);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }


    public void getResult(View v){
        Intent i = new Intent(this,result.class);

        i.putExtra("passed_url",url.getText().toString());
        i.putExtra("passed_tag1",tag1.getText().toString());
        i.putExtra("passed_tag2",tag2.getText().toString());

        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // on item selected in the spinner
        if (parent.getItemAtPosition(position) == "Search by tag"){

        }
        else if(parent.getItemAtPosition(position) == "Search by child"){



        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
