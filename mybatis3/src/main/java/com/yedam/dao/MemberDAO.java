package com.yedam.dao;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;



public class MemberDAO extends DAO {
	//회원목록 
	public List<Member> memberList(){ // 다른 패키지에서 사용 가능하게 public으로 변경 
		List <Member> list = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement("select*from tbl_member"); // 정보 가져오기 위한 쿼리 가져오기 
			rs = psmt.executeQuery(); // resultset은 쿼리 결과를 담는 컬렉션 
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClass();
		}			
		return list;
	}

	private void getOpen() {
		// TODO Auto-generated method stub
		
	}
}// close class
