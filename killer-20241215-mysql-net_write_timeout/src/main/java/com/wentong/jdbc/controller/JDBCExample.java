package com.wentong.jdbc.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class JDBCExample {
    public static void main(String[] args) {
        // 数据库连接信息
//        String url = "jdbc:mysql://localhost:3306/test?netTimeoutForStreamingResults=1&socketTimeout=100"; // 替换为你的数据库地址和名称

        String url = "jdbc:mysql://localhost:3306/test?useServerPrepStmts=true&cachePrepStmts=true&connectTimeout=500&socketTimeout=1700&netTimeoutForStreamingResults=1&logger=com.mysql.cj.log.StandardLogger&profileSQL=true&useSSL=false";
//        String url = "jdbc:mysql://localhost:3306/test?socketTimeout=1120&netTimeoutForStreamingResults=10&logger=com.mysql.cj.log.StandardLogger&profileSQL=true&useSSL=false";

        String username = "root"; // 替换为你的数据库用户名
        String password = "root"; // 替换为你的数据库密码

        // SQL 查询语句
        String sql = "SELECT u1.*,u2.* FROM user u1, user u2 WHERE u1.id = u2.id"; // 替换为你要查询的表和字段

        while (true) {

            // JDBC 连接和查询
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                conn.setAutoCommit(false
                );

                Statement stmt = conn.createStatement();
                long start = System.currentTimeMillis();
                stmt.setFetchSize(Integer.MIN_VALUE);
//            ((StatementImpl) stmt).enableStreamingResults();
                System.out.println(start);
                ResultSet rs = stmt.executeQuery(sql);
                int count = 0;
                // 处理查询结果
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("username");
                    count++;
                    if (count > 3) {

                        TimeUnit.SECONDS.sleep(1);
                    }
//                System.out.println("ID: " + id + ", Name: " + name);
                }
                System.out.println((System.currentTimeMillis() - start));
                System.out.println("count:" + count);
                rs.close();
                stmt.close();
                Thread.sleep(Long.valueOf(3000));
                break;

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }
}
