package com.bgcode.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @time : 2023/1/25 20
 * @author: bgcode
 */
public class Json {
    public static JSONArray json(String str, String key) throws Exception {
        JSONObject jsonObject = JSON.parseObject(str);
        JSONArray a = jsonObject.getJSONArray(key);
        return a;

    }

    public static String json1(String toString, String typeId) {
        JSONObject jsonObject = JSON.parseObject(toString);
        String a = jsonObject.getString(typeId);
        return a;

    }

    public void write(String sql, String url, String key, int key1, String key2, int n) throws Exception {
        json(url, key);
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 1; i < n + 1; i++) {
            preparedStatement.setString(2, url + i + "&t=" + key1);
            preparedStatement.setInt(1, key1);
            preparedStatement.setString(3, key2);
            preparedStatement.addBatch();
            if ((i) % n == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
    }

//    public void json(Object o) {
//        JSONObject jsonObject = JSON.parseObject(o);
//        JSONArray a = jsonObject.getJSONArray(key);
//        return a;
//    }
}
