package com.bgcode.pac;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @time : 2023/1/25 25
 * @author: bgcode
 */
public class pac {
    @Test
    public void test() throws Exception {
//        String urlSTr = "http://www.baidu.com/";
//        https://shayuapi.com/api.php/provide/vod/at/json/
//        https://shayujx.com/?url=//解析接口
        String urlSTr = " https://shayuapi.com/api.php/provide/vod/at/json/?ac=detail";//详情页
//        String urlSTr = "https://shayuapi.com/api.php/provide/vod/at/json/?ac=list";
        URL url = new URL(urlSTr);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        //获取http 输入流

        InputStream is = httpConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String str1 = br.readLine();

        JSONObject jsonObject = JSON.parseObject(str1);
        JSONArray a = jsonObject.getJSONArray("list");
        for (int i = 0; i < a.size(); i++) {
            lianjiechuli.json(a, i);

            print("下载成功");
        }
//        print(a.get(2));

    }

    public void print(String s) {
        System.out.print(s);
    }

    public void print(Object s) {
        System.out.print(s);
    }
}
