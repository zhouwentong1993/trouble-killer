package com.wentong.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("insert")
    public String insert() {
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
        return "OK";
    }

    @GetMapping("go")
    public String go() {
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
                conn.setAutoCommit(false);

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
        return "OK";
    }

}
