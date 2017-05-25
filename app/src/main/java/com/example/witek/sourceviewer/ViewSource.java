package com.example.witek.sourceviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
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
        final DatabaseHelper dbHelper = new DatabaseHelper(this, null, null, 1);

        Intent intent = getIntent();
        final String url = intent.getExtras().getString("address");



        if(!dbHelper.search(url)) {
            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    PageModel page = new PageModel(url, response);
                    dbHelper.addSource(page);
                    Document doc = Jsoup.parse(response);
                    progressBar.setVisibility(View.GONE);
                    dispUrl.setText(doc.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error instanceof TimeoutError || error instanceof NoConnectionError){
                        Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                        dispUrl.setText("HTTP status: " + error.networkResponse.statusCode);
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
            ConnectionHelper.getInstance(this).getRequestQueue().add(request);
        }

        else{
            PageModel page = dbHelper.getSource(url);
            Document doc = Jsoup.parse(page.getSource());
            progressBar.setVisibility(View.GONE);
            dispUrl.setText(doc.toString());

        }

    }
}
