package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록가져오기
	List<BoardVO> boardList(int page);
	
	// 등록(삽입)
	boolean registerBoard(BoardVO board);
	
	// 삭제
	boolean removeBoard(int boardNo);
	
	// 수정 (변경)
	boolean modifyBoard(BoardVO board);
		
	// 단건 조회 
	BoardVO searchBoard(int boardNo);
	
}
