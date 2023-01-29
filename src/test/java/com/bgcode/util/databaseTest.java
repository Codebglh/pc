package com.bgcode.util;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @time : 2023/1/25 08
 * @author: bgcode
 */
public class databaseTest extends TestCase {

    public void testGetConnection() throws Exception {
        Connection connection = database.getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS `ss`(\n" +
                "   `id` INT UNSIGNED AUTO_INCREMENT,\n" +
                "   `name` VARCHAR(100) ,\n" +
                "   `url` VARCHAR(40) ,\n" +
                "   PRIMARY KEY ( `id` )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "insert into shayu.ss values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {

            preparedStatement.setString(1, "dsd" + i);
            preparedStatement.setString(2, "sd");
            preparedStatement.addBatch();
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();

            }


        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        database.close(null, preparedStatement, connection);


    }

}

