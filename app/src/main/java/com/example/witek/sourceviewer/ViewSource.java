package com.example.witek.sourceviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSource extends AppCompatActivity {

    TextView dispUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_source);

        dispUrl  = (TextView) findViewById(R.id.displayUrl);

        Intent intent = getIntent();
        String url = intent.getExtras().getString("address");

        dispUrl.setText(url);


        //TODO view the source of a webpage
        //TODO set the connection and get data using Volley
        //TODO parse the HTML code
        //TODO create a table in the database
        //TODO save the raw string obtained from Volley to the database
        //TODO handle any errors
    }
}
