package com.cjq.accounts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 加载数据库驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/accounts?characterEncoding=gbk";
			String user = "cjq617";
			String password = "1215617";
			//获得数据库连接对象
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println(conn);
		} catch (ClassNotFoundException e1) { // 捕获加载数据库驱动程序时所抛出的异常
			System.out.println("数据库驱动程序错误");
		} catch (SQLException e2) { // 捕获创建Connection对象时所抛出的异常
			System.out.println("创建数据库连接错误");
		} catch (Exception e3) { 
			e3.printStackTrace();
		}
		return conn;
	}
}
