package com.bgcode.pac;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bgcode.util.database;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @time : 2023/1/24 30
 * @author: bgcode
 */
public class URl {
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
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);


        }
        JSONObject jsonObject = JSON.parseObject(str1);
        String id = String.valueOf(jsonObject.getJSONArray("list"));
//        JSONArray list = JSON.parseArray(id);
//        vod_pic vod_name
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//
//
//        }
//        System.out.println(id);
    }

//    @Test
//    public void test1() {
//        // 打开浏览器
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        // 输入url地址
//        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
//        CloseableHttpResponse response = null;
//        try {
//            // 敲回车，发送请求，获取响应
//            response = httpClient.execute(httpGet);
//            // 获取内容
//            String result = EntityUtils.toString(response.getEntity(), "utf-8");
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (response != null) {
//                    response.close();
//                }
//                if (httpGet != null) {
//                    httpGet.releaseConnection();
//                }
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Test


    public void addMXL1() throws Exception {
        Connection connection = database.getConnection();
        String sql = "insert into shayu.movie values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 5000; i++) {
//            preparedStatement.setString(1, "dsd" + i);
//            preparedStatement.setString(2, "sd");
//            preparedStatement.executeUpdate();
//
//
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        database.close(null, preparedStatement, connection);


    }
}
