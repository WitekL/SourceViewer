package com.example.witek.sourceviewer;

/**
 * Created by Witek on 22.05.2017.
 */

public class PageModel {

    String address;
    String source;

    public PageModel(String addres, String source) {
        this.address = addres;
        this.source = source;
    }


    public String getAddress() {
        return address;
    }

    public void setAddres(String addres) {
        this.address = addres;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
