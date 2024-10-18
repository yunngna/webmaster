package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록가져오기
	//List<BoardVO> boardList(SearchDTO search);
	
	//페이징 포함해서 목록 전체 가져오기
	List<BoardVO> listWithPage(SearchDTO search);
	
	// 등록(삽입)
	boolean registerBoard(BoardVO board);
	
	// 삭제
	boolean removeBoard(int boardNo);
	
	// 수정 (변경)
	boolean modifyBoard(BoardVO board);
		
	// 단건 조회 
	BoardVO searchBoard(int boardNo);
	
	// 페이징카운트(데이터 갯수 가져오기)
	int getTotalCount(SearchDTO search);
	
}
