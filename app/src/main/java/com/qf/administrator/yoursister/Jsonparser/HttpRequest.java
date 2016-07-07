package com.qf.administrator.yoursister.Jsonparser;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class HttpRequest {
    public static String downJsonString(String urlstring) {
        if(!TextUtils.isEmpty(urlstring)){
            HttpURLConnection con = null;
            InputStream is = null;
            StringBuffer sBuffer = null;
            BufferedReader br=null;
            try {
                URL url = new URL(urlstring);
                con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5 * 1000);
                con.setReadTimeout(5 * 1000);
                con.connect();
                if (con.getResponseCode() == 200) {
                    is = con.getInputStream();
                    sBuffer=new StringBuffer();
                    br=new BufferedReader(new InputStreamReader(is));
                    String len = null;
                    while ((len = br.readLine()) !=null){
                        sBuffer.append(len);
                    }
                    return sBuffer.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (con != null) {
                    con.disconnect();
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
