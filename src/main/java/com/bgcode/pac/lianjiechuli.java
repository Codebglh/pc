package com.bgcode.pac;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.bgcode.util.NETconnect;
import com.bgcode.util.database;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @time : 2023/1/25 33
 * @author: bgcode
 */
public class lianjiechuli {
    @Test
    public void url() throws Exception {
        String url = "https://shayuapi.com/api.php/provide/vod/at/json/?ac=detail";
//        String a =

        JSONObject jsonObject = JSON.parseObject(NETconnect.getURLConnection(url));
        JSONArray a = jsonObject.getJSONArray("list");
        for (int i = 0; i < a.size(); i++) {
            json(a, i);

        }
        NETconnect.print("成功");

    }

    static void json(JSONArray a, int i) throws SQLException {

        String data = a.get(i).toString();
        JSONObject shuru = JSON.parseObject(data);
        String vod_pic = shuru.getString("vod_pic");
        String vod_name = shuru.getString("vod_name");
        String vod_play_url = shuru.getString("vod_play_url");
        String type_name = shuru.getString("type_name");
        String type_id = shuru.getString("type_id");
        Connection connection = database.getConnection();
        String sql = "insert into movie values(null,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, type_id);
        preparedStatement.setString(2, vod_name);
        preparedStatement.setString(3, vod_pic);
        preparedStatement.setString(4, vod_play_url);
        preparedStatement.setString(5, type_name);
        preparedStatement.executeUpdate();
        database.close(null, preparedStatement, connection);
    }
}
