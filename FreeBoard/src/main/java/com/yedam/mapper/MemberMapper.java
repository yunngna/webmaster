package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.CalendarVO;
import com.yedam.vo.MemberVO;

// interface 기능 정의  
// 구현 클래스를 통해서 그 기능을 실행한다. 
public interface MemberMapper {
	// 전체 조회
	public List<MemberVO> members();
	// 삽입
	public int insertMember(MemberVO member);
	// 수정
	public int updateMember(MemberVO member);
	//삭제
	public int deleteMember(String memberId);
	// 단건 조회 
	public MemberVO selectMember(String memberId);
	
	// id 와 password 조회 
	public MemberVO loginMember(@Param("id") String id , @Param("pw")String pw);
	
	//캘린더 데이터 조회
	List<Map<String,Object>>selectcalendars();
	
	//캘린더 추가
	public int addEvent(CalendarVO event);

}
