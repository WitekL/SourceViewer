package com.example.witek.sourceviewer;

/**
 * Created by Witek on 22.05.2017.
 */

public class PageModel {

    String address;
    String source;

    public PageModel(String address, String source) {
        this.address = address;
        this.source = source;
    }


    public void set(String address, String source) {
        this.address = address;
        this.source = source;
    }


    public String getAddress() {
        return address;
    }


    public String getSource() {
        return source;
    }

}
