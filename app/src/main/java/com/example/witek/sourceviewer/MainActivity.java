package com.example.witek.sourceviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendUrl;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendUrl  = (Button) findViewById(R.id.sendButton);
        url = (EditText) findViewById(R.id.url);


        sendUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressInitial = url.getText().toString();
                String address = "";

                if(!(addressInitial.substring(0, 7).equals("http://"))){
                   address = "http://" + addressInitial;
                }
                else address = addressInitial;

                Intent intent = new Intent(getApplicationContext(), ViewSource.class);
                intent.putExtra("address", address);
                startActivity(intent);
            }
        });

    }


}
