package com.gdsc.pknu.backend;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class JDBCTest {
    static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:mysql://gdsc-database.c7dfridgy6ma.ap-northeast-2.rds.amazonaws.com:3306/gdsc_pknu?serverTimezone=Asia/Seoul",
						"admin",
						"gdsc_pknu22")){
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
