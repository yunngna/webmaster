package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
//목록 출력
//	@Override
//	public List<ReplyVO> selectList(int boardNo) {
//		return mapper.selectList(boardNo);
//	}

//페이징 목록 출력
	@Override
	public List<ReplyVO> selectList(int boardNo,int page) {
		return mapper.selectListPasing(boardNo,page);
	}


	@Override
	public boolean deleteReply(int replyNo) {
		return mapper.deleteReply(replyNo) ==1;
	}

	@Override
	public boolean addReply(ReplyVO reply) {
		return mapper.addReply(reply) ==1;
	}

	@Override
	public ReplyVO selectReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}


	@Override
	public int replyCount(int boardNo) {
		return mapper.selectCount(boardNo);
	}
	

}
