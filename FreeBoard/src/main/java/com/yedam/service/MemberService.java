package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

//업무처리로직 (회원추가,회원삭제)
public interface MemberService {
	// 회원추가
	boolean addMember(MemberVO member);
	
	//회원삭제
	boolean retireMember(String memberId); 
	
	//회원목록출력메소드
	List<MemberVO>memberList();
	
	// 로그인 
	MemberVO loginCheck(String id , String pw);
	
}
