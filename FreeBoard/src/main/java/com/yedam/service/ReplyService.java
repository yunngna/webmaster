package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> selectList(int boardNo); 
	
	boolean deleteReply (int ReplyNo);
	
	boolean addReply(ReplyVO reply);
	
	ReplyVO selectReply (int replyNo);
}
