package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

	public static void main(String[] args) {
		// 데이터 조회
		// 연결
		Connection conn = null;
		
		try {
			//jdbc 등록
			Class.forName("oracle.jdbc.OracleDriver");
		
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
				
			// 데이터 조회 
			String sql = "select * from boards " + 
			             " where bwriter = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"글쓴이1");
			ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()) { // bd 라는 board타입의 객체를 각각 만들어서 각각의 필드를 저장한다. 
				Board bd = new Board();
				bd.setBno(rs.getInt(1)); // table column 순서 
				bd.setBtitle(rs.getString(2));
				bd.setBcontent(rs.getString(3));
				bd.setBwriter(rs.getString(4));
				bd.setBdate(rs.getDate(5));
				
				System.out.println(bd); // board class에서 to String 해줘서 value가 나온다. 원래는 주소만 나오게 된다. 
			}
			rs.close();
		}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		 } finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
