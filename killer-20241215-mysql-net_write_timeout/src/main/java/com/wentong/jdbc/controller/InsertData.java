package com.wentong.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertData {

    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&connectTimeout=10000&socketTimeout=10000";
        String username = "root";  // 替换为你的数据库用户名
        String password = "root";  // 替换为你的数据库密码

        // SQL 插入语句
        String sql = "INSERT INTO `user` (`username`) VALUES (?)";

        // 批量插入的记录数
        int batchSize = 10000;  // 每次批量插入 1000 条记录
        int totalRecords = 1000000;  // 总共插入 10 万条记录

        // 随机生成用户名
        Random random = new Random();

        // JDBC 连接和批量插入
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 关闭自动提交，启用手动提交
            conn.setAutoCommit(false);

            // 插入 10 万条记录
            for (int i = 1; i <= totalRecords; i++) {
                String randomUsername = "user" + (i + random.nextInt(10000));  // 生成随机用户名

                pstmt.setString(1, randomUsername);
                pstmt.addBatch();

                // 每批次插入 batchSize 条记录
                if (i % batchSize == 0 || i == totalRecords) {
                    pstmt.executeBatch();  // 执行批量插入
                    conn.commit();  // 提交事务
                }
            }

            System.out.println("成功插入 " + totalRecords + " 条记录");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
