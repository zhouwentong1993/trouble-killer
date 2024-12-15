package com.wentong.jdbc;



import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class JDBCExample {
    public static void main(String[] args) {
        // 数据库连接信息
//        String url = "jdbc:mysql://localhost:3306/test?netTimeoutForStreamingResults=1&socketTimeout=100"; // 替换为你的数据库地址和名称
        String url = "jdbc:mysql://localhost:3306/test?netTimeoutForStreamingResults=1&socketTimeout=100&logger=com.mysql.cj.log.StandardLogger&profileSQL=true&useSSL=false";

        String username = "root"; // 替换为你的数据库用户名
        String password = "12345678"; // 替换为你的数据库密码

        // SQL 查询语句
        String sql = "SELECT u1.*,u2.* FROM user u1, user u2 WHERE u1.id = u2.id"; // 替换为你要查询的表和字段

        // JDBC 连接和查询
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            long start = System.currentTimeMillis();
            stmt.setFetchSize(Integer.MIN_VALUE);
            ((StatementImpl) stmt).enableStreamingResults();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(start);
            int count = 0;
            // 处理查询结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                count++;
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("ID: " + id + ", Name: " + name);
            }
            System.out.println((System.currentTimeMillis() - start));
            System.out.println("count:" + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
