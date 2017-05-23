package com.example.witek.sourceviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ViewSource extends AppCompatActivity {

    TextView dispUrl;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_source);

        dispUrl  = (TextView) findViewById(R.id.displayUrl);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String url = intent.getExtras().getString("address");
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document doc = Jsoup.parse(response);
                progressBar.setVisibility(View.GONE);
                dispUrl.setText(doc.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dispUrl.setText("w8 w8 w8, somtink ronk");
                error.printStackTrace();
            }
        });


        ConnectionHelper.getInstance(this).getRequestQueue().add(request);





        //TODO create a table in the database
        //TODO save the raw string obtained from Volley to the database
        //TODO handle any errors
        
    }
}
