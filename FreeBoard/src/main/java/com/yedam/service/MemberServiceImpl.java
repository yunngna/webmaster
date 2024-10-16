package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// 구현 
// 데이터베이스종류 변경 (mysql [insertMember, updateMember] -> oracle [memberInsert,memberUpdate] 로 변경 시 각각 찾아서 수정을 다 해줘야한다. )
// 그래서 인터페이스를 사용해서 인터페이스에 사용한 대로 사용해야 하므로 'add unimplemented method' 을 눌러서 정해진 이름으로 사용 하게 된다. 

public class MemberServiceImpl implements MemberService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member)==1;
	}
	
	@Override
	public boolean retireMember(String memberId) {
		return mapper.deleteMember(memberId)==1;
	}
	


}
