package com.bgcode.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @time : 2023/1/25 18
 * @author: bgcode
 */
public class NETconnect {
    public static String getURLConnection(String urlSTr) throws Exception {
        URLConnection urlConnection = new URL(urlSTr).openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        InputStream is = httpConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String str1 = br.readLine();
        is.close();
        isr.close();
        br.close();
        return str1;
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void print(Object s) {
        System.out.print(s);
    }
}
