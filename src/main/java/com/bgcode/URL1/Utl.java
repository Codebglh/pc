package com.bgcode.URL1;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.bgcode.util.NETconnect;
import com.bgcode.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @time : 2023/1/25 54
 * @author: bgcode
 */
public class Utl {
    final static String class1 = "https://shayuapi.com/api.php/provide/vod/at/json/?ac=list";
    final static String url = "https://shayuapi.com/api.php/provide/vod/at/json/?";
    final static String url2 = "https://shayuapi.com/api.php/provide/art/at/json/?";
    StringBuffer buffer = new StringBuffer(url);

    public static void setUrl(StringBuffer a, int n) {
        for (int i = 1; i < n; i++) {
            a.append("ac=detail" + "pg=" + i + "t=22");
        }
    }


    public static void main(String[] args) throws Exception {
        JSONObject jsonObject = JSON.parseObject(NETconnect.getURLConnection(class1));
        JSONArray a = jsonObject.getJSONArray("class");
        for (int i = 0; i < a.size(); i++) {
            String data = a.get(i).toString();
            JSONObject shuru = JSON.parseObject(data);
            String type_name = shuru.getString("type_name");
            String type_id = shuru.getString("type_id");
            Connection connection = database.getConnection();
            String sql = "insert into class values(null,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type_id);
            preparedStatement.setString(2, type_name);
            preparedStatement.executeUpdate();
            database.close(null, preparedStatement, connection);

        }
        NETconnect.print("成功");
    }
}
