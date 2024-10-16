package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends DAO {
	// 필드
	// 메소드

	// 3. insert 메소드
	public int insert(Book book) {
		getOpen();
		try {
		String sql = ""
				+ "insert into book (title,writer,price,bnum) "
				+ "values ( ?, ?, ?, ? )";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4,book.getBnum());
			
			//sql문장 실행 
			int rows= pstmt.executeUpdate();
			getClose();
			return rows;	
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 4. select : 조건에 따른 검색 (책제목)메소드
	public Book select(String title) {
		getOpen();
		try {
			String sql = "select * from book "+
					    "where title  = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setTitle(rs.getString(1));
				bk.setWriter(rs.getString(2));
				bk.setPrice(rs.getInt(3));
				bk.setBnum(rs.getString(4));
				getClose();
				return bk;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	// 5. select : 목록 전체 조회 메소드 (list 에 받아 저장)
	public void selectAll() {
		getOpen();
		try {
			String sql = "select * from book ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Book>list = new ArrayList<>();

			while (rs.next()) {
				list.add(new Book (rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
				
			}
			for (Book bk : list) {
				System.out.println(bk.getTitle() + bk.getWriter() + bk.getPrice() + bk.getBnum());	
			}
			getClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	// 6. delete 메소드 (북번호 이용)
	public int remove (String bnum) {
		getOpen();
		try {
			String sql = "delete from book " +
						"where bnum=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	// 7. update 메소드 (책제목의 가격과 책 번호를 수정)
	public int update(String title, int price, String bnum) {
		getOpen();
		try {
			String sql = ""+
					"update book "+
					"set price=?, bnum=? "+
					"where title=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, bnum);
			pstmt.setString(3, title);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}//close class


