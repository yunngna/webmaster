package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		// 연결하기
		Connection conn = null;
		
		try {
			//jdbc 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe", //url
					"java", // 계정
					"1234" // 비밀번호 
					);
			System.out.println("연결성공");
			
			
			//데이터 수정 
			String sql = "" + 
						"update boards " +
						"set btitle=?, bcontent=? " + 
						"where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql , new String[] {"bno","btitle","bcontent"});
			pstmt.setString(1, "거북이");// 첫번째 ? 에 변경 될 사항  
			pstmt.setString(2, "너무기여버");  // 두번째 ? 에 변경될 사항 
			pstmt.setInt(3, 5);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수:" + rows );
			
//			if(rows == 1) {
//				ResultSet rs = pstmt.getGeneratedKeys();
//				if (rs.next()) {
//					int bno = rs.getInt(1); 
//					String title = rs.getNString(2);
//					String content = rs.getNString(3);
//					System.out.printf("%d : %s : %s",bno,title,content);
//				}
//			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (conn != null){
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
