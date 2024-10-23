package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
//	List<ReplyVO> selectList(int boardNo); // 목록
	
	List<ReplyVO> selectList(int boardNo,int page);// 페이징목록
	
	boolean deleteReply (int ReplyNo);//댓글삭제
	
	boolean addReply(ReplyVO reply); // 댓글 추가
	
	ReplyVO selectReply (int replyNo);// 단건 조회 
	
	int replyCount(int boardNo); // 댓글 갯수 조회 
}
