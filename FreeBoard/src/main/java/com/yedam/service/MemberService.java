package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalendarVO;
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
	
	//캘린더 조회 
	List<Map<String,Object>> eventList();
	
	//캘린더 추가 
	boolean addEvent(CalendarVO event);
	
	//캘린더 삭제
	boolean removeEvent(CalendarVO event);
	
	//프로젝트 테스트용 
	//로그인 
		MemberVO MemberLogin(String memberId ,String password);
	
}
