package com.example.witek.sourceviewer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Witek on 24.05.2017.
 */
public class PageModelTest {
    @Test
    public void set() throws Exception {

        String desiredAddress = "http://www.google.com" ;
        String desiredSource = "<html><body></body></html>";


        PageModel pageModel = new PageModel(null, null);
        pageModel.set("http://www.google.com", "<html><body></body></html>");

        assertEquals(desiredAddress, pageModel.getAddress());
        assertEquals(desiredSource, pageModel.getSource());
    }
}