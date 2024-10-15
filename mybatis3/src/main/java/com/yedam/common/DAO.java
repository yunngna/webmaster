package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// oracledb 연결 클래스 

public class DAO {
	// 1. 연결설정 메소드(void) : public으로 해줘야 다른 패키지에서 사용가능하다. 
	public Connection conn = null;
	public PreparedStatement psmt;
	public ResultSet rs;

	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234");
				System.out.println("연결 성공");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	// 2. 연결끊기 메소드(void)
	public void getClose() {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("연결 끊기");
			}
		}
	
}
