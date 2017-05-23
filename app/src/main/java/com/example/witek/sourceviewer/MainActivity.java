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
                String address = url.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ViewSource.class);
                intent.putExtra("address", address);
                startActivity(intent);
            }
        });


        // TODO get the URL and send it via intent to the next activity
    }


}
