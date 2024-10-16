package com.yedam.dao;

import java.util.List;

import com.yedam.vo.Member;

// interface 기능 정의  
// 구현 클래스를 통해서 그 기능을 실행한다. 
public interface MemberMapper {
	// 전체 조회
	public List<Member> members();
	// 삽입
	public int insertMember(Member member);
	// 수정
	public int updateMember(Member member);
	//삭제
	public int deleteMember(String memberId);
	// 단건 조회 
	public Member selectMember(String memberId);

}
