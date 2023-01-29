package com.bgcode.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @time : 2023/1/22 10
 * @author: bgcode
 */
public class database {
    private static String user, password, url;

    static {//静态代码块直接将代码进行实例化
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/mysql.properites"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, PreparedStatement result, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (result != null) {
                result.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
