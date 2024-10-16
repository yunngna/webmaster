package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		// 연결 
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // jdbc 드라이버 가져오기 ( 드라이버가 포함된 class 불러오기)
		
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
						);
				System.out.println("연결성공");
				
				// 데이터 삭제
				String sql = "delete from boards " +
				              "where bno=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 6); // ? 번째 = 1번째 , bno = 2
				int rows = pstmt.executeUpdate(); // 실행업데이트 된 갯수 
				System.out.println("삭제행 수 :" + rows);
				
				pstmt.close();
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null){
				try {
					conn.close();
					System.out.println("연결끊기");
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}

	}

}
