package com.spring;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class day01_01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        DriverManager.registerDriver( new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bzzworld_pg", "root", "root");
        //3.获取预处理对象
        PreparedStatement ps = con.prepareStatement("select * from mcc_customer limit 10");
        //4.执行SQL 获取返回集合
        ResultSet rs = ps.executeQuery();
        //5.遍历集合
        while(rs.next()){
            System.out.println(rs.getString("memberNo"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        con.close();

    }
}
