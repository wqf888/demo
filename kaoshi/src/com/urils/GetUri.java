package com.urils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class GetUri {
	
	
	
	public static Connection getconn() throws Exception{
		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		System.out.println("数据库链接成功："+conn);
		return conn;
	}
	
	
	
	@Test
	public void test1() throws Exception{
		this.getconn();
	}
	
}
