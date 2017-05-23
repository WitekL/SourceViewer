package com.example.witek.sourceviewer;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by witol on 23.05.2017.
 */

class ConnectionHelper {
    private static ConnectionHelper myInstance = null;
    private RequestQueue requestQueue;
    private static Context myContext;


    static ConnectionHelper getInstance(Context context) {
        if(myInstance == null)  myInstance = new ConnectionHelper(context);
        return myInstance;
    }

    private ConnectionHelper(Context context) {
        myContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return requestQueue;
    }
}
