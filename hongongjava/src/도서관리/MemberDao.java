package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//목록(조회조건), 등록 (insert), 가져오기 (select) , 수정 (update) , 삭제 (delete), 단건 조회 
public class MemberDao extends DAO {
	
	//싱글턴 방식 (instance를 줄이기 위해서 접근 제한을 걸어 둔다. ) 
	private static MemberDao instance = new MemberDao(); // MemberDao 접근 방지  
	private MemberDao() {} // 생성자 접근 방지 
	public static MemberDao getInstance() {
		return instance; // 오직 getInstance() 메소드로만 접근 하게 만든다. 
	}
	//connection , getOpen , getClose ( DAO 가 가지고 있는) 모두 사용 가능 하다. 
	
	//아이디와 비밀번호를 확인해서 true 반환/ false반환 [boolean 타입 사용] ( 아이디 비밀번호 확인 1) 
//	boolean checkMember(String id, String pw) {
//		String sql = "select count(1) from tbl_member " // count(1)이란 sql 1번째 컬럼의 갯수 
//					+ "where member_id = ? and password = ? ";
//		getOpen();
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, pw);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				int cnt =  rs.getInt(1); //결과값이 id password 둘다 맞으면 1 리턴, 둘중 하나라도 안맞으면 0리턴 
//				if(cnt > 0) { // id 와 password가 정상적이면 true 
//					return true;
//				}
//			}
//		} catch (SQLException e) { // id와 password 가 없거나 예외발생시 false
//			e.printStackTrace();
//		} return false;
//	}//close checkMember()
	
	
	//아이디 비밀번호 확인 한후 맞으면 이름 뜨며 환영 메세지 출력  (아이디 비밀번호 확인 2) 
//	String checkMember(String id, String pw) {
//		String sql = "select member_name from tbl_member "
//					+ "where member_id = ? and password = ? ";
//		getOpen();
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, pw);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				return rs.getString(1); //결과값이 id password 둘다 맞으면 1 리턴, 둘중 하나라도 안맞으면 0리턴 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} return null; // string 타입이기 때문에 null 과 공백("") 둘다 가능 
//	}//close checkMember()
	
	//아이디 비밀번호 확인 한후 맞으면 이름 뜨며 환영 메세지 출력 + 권환 추가  (아이디 비밀번호 확인 3)  [1개 이상의 정보(이름 , 권한) 를 출력해야 하기 때문에 타입은 class타입 ]
		Member checkMember(String id, String pw) {
			String sql = "select member_name , responsibility from tbl_member "
						+ "where member_id = ? and password = ? ";
			getOpen();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				rs = psmt.executeQuery();
				if(rs.next()) {
					Member member = new Member();
					member.setMemberName(rs.getString("member_name"));
					member.setReponsibility(rs.getString("responsibility"));
					return member;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} return null; // string 타입이기 때문에 null 과 공백("") 둘다 가능 
		}//close checkMember()
	
	//1. 회원등록 (insert)
		int insert (Member member) {
			getOpen();
			String sql = ""
					  + "insert into tbl_member (member_id, password, member_name, phone) "
					  + "values ( ?, ?, ?, ?)";
			try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2,member.getPassword());
			psmt.setString(3, member.getMemberName());
			psmt.setString(4, member.getPhone());
			
			int rows = psmt.executeUpdate();
			getClose();
			return rows;
			
			}
			catch (SQLException e) {
//			e.printStackTrace();
			return 0;
			}
		}	
					  
		
	//2. 회원검색 (select)
	Member select (String id) {
		getOpen();
		String sql = "select * from tbl_member "
				   + "where member_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.setMemberId(rs.getString("member_id"));
				mb.setPassword(rs.getString("password"));
				mb.setMemberName(rs.getString("member_name"));
				mb.setPhone(rs.getString("phone"));
				mb.setReponsibility(rs.getString("responsibility"));
				mb.setCreationDate(rs.getDate("creation_date"));
				getClose();
				return mb;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	}//close select 
	
	
	
	
	//3. 목록 조회 
	
	//컬렉션 <타입> 메소드이름(실행){.... }
	List<Member> memberList() {
		String sql = "select member_id"
					+ "     ,member_name"
					+ "     ,password"
					+ "     ,phone"
					+ "     ,responsibility"
					+ "     ,creation_date"
					+ " from  tbl_member ";
		
		List<Member> result = new ArrayList<>(); // List<Member>형태의 결과가 나오게 ArrayList<>()실행해서 값 담기 
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				member.setReponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				result.add(member); // arraylist 배열에 내용 저장(삽입)
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}//close memberList()
	
	//4. 회원 삭제
	int delete (String id) {
		getOpen();
		String sql = "delete from  tbl_member "
					+"where member_id = ?";
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		int rows = psmt.executeUpdate();
		getClose();
		return rows;
		}catch(SQLException e) {
			e.printStackTrace();
		}return 0;
	}
	//5. 회원정보 변경
	int update (String id , String pw, String name, String phone, String responsibility) {
		getOpen();
		String sql = "" 
				  + "update tbl_member "
				  + "set password=? , member_name=?, phone=?, responsibility=?"
				  + "where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, name);
			psmt.setString(3, phone);
			psmt.setString(4, responsibility);
			psmt.setString(5, id);
			
			int rows = psmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
					
	}
	
	

}//close class
