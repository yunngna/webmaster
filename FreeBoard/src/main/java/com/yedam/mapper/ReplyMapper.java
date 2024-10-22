package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//댓글 보여주기 (글 번호 boardNo 에 대한)
	List<ReplyVO> selectList (int boardNo);
	
	//댓글 삭제
	int deleteReply (int boardNo);
	
	//댓글 등록 
	int addReply(ReplyVO reply);
	
	//단건조회
	ReplyVO selectReply(int replyNo);
	
}
