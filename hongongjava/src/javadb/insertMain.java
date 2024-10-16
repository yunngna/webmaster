package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertMain {

	public static void main(String[] args) {
		// data(데이터) 추가
		Connection conn = null;
		//jdbc 드라이버 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 
			try {
				conn = DriverManager.getConnection(
						"jdbc:Oracle:thin:@localhost:1521:xe",
						"java",
						"1234"						
						);
				System.out.println("연결 성공 ");
				
				//데이터 추가 
				String sql = ""
						+ "insert into boards (bno,btitle,bcontent,bwriter,bdate) "
						+ "values (seq_bno.nextVal, ?, ?, ?, sysdate)"; 
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"}); 
				pstmt.setString(1, "눈오는 밤");
				pstmt.setString(2, "눈이 펑펑 내려요");
				pstmt.setString(3, "snow");
			
				int rows = pstmt.executeUpdate(); // 데이터 삽입시 excuteUpdate 
				if(rows == 1) {
					ResultSet rs = pstmt.getGeneratedKeys(); //ResultSet : 데이터 베이스의 값을 가져오는 것
					if(rs.next()) {
						int bno = rs.getInt(1); // new String[] {"bno","btitle"} 에서 1: 배열의 첫번째 즉 bno
						String title = rs.getNString(2);
						System.out.println("저장된 번호" + bno + title);	 // 현재 몇번째에 저장되는지 나타내는것 이런 경우 squence 가 포함된 bno을 배열로 만들어서 뒤에 추가 해주면 알 수 있다. 
					}
					System.out.println("추가 성공");
					rs.close();
				}else {
					System.out.println("추가 실패");
				}
				pstmt.close(); // 사용한 모든 자원을 닫아주기 
				
		} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

}
