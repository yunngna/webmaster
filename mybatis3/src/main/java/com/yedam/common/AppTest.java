package com.yedam.common;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.vo.Member;

import main.java.com.yedam.dao.MemberMapper;

public class AppTest {
	public static void main(String[] args) { // 메인 메소드 형성 
//		MemberDAO dao =  new MemberDAO();
//		List<Member> result = dao.memberList();
//		for (Member member : result) {
//			System.out.println(member.toString());
		
		// Mybatis 사용 
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		// 등록 
		Member mbr = new Member();
		
		// insert  실행
//	    mbr.setMemberId("Test88");
//		mbr.setMemberName("연습99");
//		mbr.setPhone("010-9999-9999");
//		mbr.setPassword("123456");
//		
//		if (dao.insertMember(mbr)==1) {
//			sqlSession.commit();
//		};
//		
		// update 실행 
//		mbr.setMemberId("Test99");
//		mbr.setMemberName("연습12");
//		mbr.setPhone("010-1234-5678");
//		mbr.setPassword("999");
//		if(dao.updateMember(mbr)==1) {
//			sqlSession.commit();
//		}
//		
		// delete 실행 
//		mbr.setMemberId("Test88");
//		if(dao.deleteMember(mbr.getMemberId())==1) {
//			sqlSession.commit();
//		}
		
		
		// 전체 출력 
//		List<Member> result = dao.members();
//		for (Member member : result) {
//			System.out.println(member.toString());			
//		}
		
		
		
	}
}// close class
