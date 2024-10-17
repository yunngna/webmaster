package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // mapper 가져오기

//전체 출력 
//	@Override
//	public List<BoardVO> boardList() {
//		return mapper.boardList();
//	}

//페이징 전체 출력 
	@Override
	public List<BoardVO> boardList(int page) {
		return mapper.listWithPage(page);
	}
//등록
	@Override
	public boolean registerBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(board) == 1;
	}

// 삭제
	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo)==1 ;
	}

// 정보 변경 
	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}
// 단건조회 ( view 카운트 증가 )
	@Override
	public BoardVO searchBoard(int boardNo) {
		mapper.updateCount(boardNo); // 조회수 증가 
		return mapper.selectBoard(boardNo);
	}
	
}
