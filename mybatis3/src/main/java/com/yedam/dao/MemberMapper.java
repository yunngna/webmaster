package com.yedam.dao;

import java.util.List;

import com.yedam.vo.Member;

// interface 기능 정의  
// 구현 클래스를 통해서 그 기능을 실행한다. 
public interface MemberMapper {
	public List<Member> members();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String memberId);

}
