package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	// 게시글 목록 가져오기  
//	List<BoardVO> boardList (); // 컬렉션을 사용하면 목록이 한건 나오면 출력이 된다.
	
	// 페이징 처리해서 목록 가져오기 (page를 paramete로 받아서 실행)
	List<BoardVO>listWithPage(int page);
	
	// 게시글 등록 
	int insertBoard(BoardVO board);
	
	//게시글 수정
	int updateBoard(BoardVO board);
	
	// 게시글 삭제 
	int deleteBoard(int boardNo);
	
	// 글 상세 조회
	BoardVO selectBoard(int boradNo); // 한건 이상이 나오면 오류 (여러건 나오면 무조건 컬렉션)

	// 조회수 증가 
	int updateCount(int boardNo);
	
}
