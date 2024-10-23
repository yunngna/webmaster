package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//댓글 보여주기 (글 번호 boardNo 에 대한)
	List<ReplyVO> selectList (int boardNo);
	List<ReplyVO> selectListPasing (@Param("bno")int boardNo, @Param("page")int page); //@Param 이름을 지정 하는 것 
	
	//댓글 삭제
	int deleteReply (int boardNo);
	
	//댓글 등록 
	int addReply(ReplyVO reply);
	
	//단건조회
	ReplyVO selectReply(int replyNo);
	
	//댓글 총 건수 조회
	int selectCount(int boardNo);
	
}
