package com.bgcode.URL1;

import com.bgcode.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @time : 2023/1/25 13
 * @author: bgcode
 */
public class urlcreate {
    static String url = "https://shayuapi.com/api.php/provide/vod/at/json/?ac=detail&pg=";


    public static void main(String[] args) throws Exception {
        urlcreate s = new urlcreate();
        int[] a = {1, 2, 3, 20, 21, 22, 23, 24, 25, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 40};
        String[] b = {"国产情色", "日本无码", "AV明星", "中文字幕", "网红主播", "成人动漫", "欧美情色", "国模私拍", "长腿丝袜", "邻家人妻", "韩国伦理", "香港伦理", "精品推荐", "原纱央莉", "柚木TINA", "大桥未久", "AV明星1", "仁科百华", "天海翼", "小川阿佐美", "三上悠亚", "长泽梓"};
        for (int i = 0; i < a.length; i++) {

        }

        s.ss(2193, a, b);

        ;

    }

    public void ss(int n, int[] a, String[] b) throws Exception {
        String sql = "insert into shayu.url values(null,?,?,?)";
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int j = 0; j < a.length; j++) {
            for (int i = 1; i < n + 1; i++) {
                preparedStatement.setString(2, url + i + "&t=" + a[j]);
                preparedStatement.setInt(1, a[j]);
                preparedStatement.setString(3, b[j]);
                preparedStatement.addBatch();
                if ((i) % 2193 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();

                }
            }


        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        database.close(null, preparedStatement, connection);

    }
}
