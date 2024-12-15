package com.wentong.jdbc;

import java.sql.*;

public class JDBCExample1 {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/test?netTimeoutForStreamingResults=10&socketTimeout=100&useSSL=false";

            String username = "root"; // 替换为你的数据库用户名
            String password = "12345678"; // 替换为你的数据库密码
            String sql = "SELECT id, username FROM user"; // 替换为你要查询的表和字段

            Connection conn = DriverManager.getConnection(url, username, password);
            while (true) {

                conn.setAutoCommit(false);
                Statement stmt = conn.createStatement();
                stmt.setFetchSize(Integer.MIN_VALUE);

                long start = System.currentTimeMillis();
                ResultSet rs = stmt.executeQuery(sql);
                int count=0;
                while (rs.next()) {
                    System.out.println("id:"+rs.getInt("id")+" count:"+count);
                    count++;
                    if(count<3) //1 秒后数据库端连接就已经关闭了，但是因为客户端读得慢，需要不 sleep 后才能读到 fin 然后报错，所以报错可以比实际晚很久
                        Thread.sleep(1500);
                }
                rs.close();
                stmt.close();
                Thread.sleep(Long.valueOf(100000));
                break;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
