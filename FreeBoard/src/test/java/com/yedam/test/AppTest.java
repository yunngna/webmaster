package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // mapper 가져오기
		
		// 삽입 (글 내용 입력 )
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper테스트");
//		bvo.setContent("정상 작동 됩니다.");
//		bvo.setWriter("user01");
		
//		if (mapper.insertBoard(bvo) == 1) {
//			sqlSession.commit();
//		};
		
		// 수정 
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper테스트");
//		bvo.setContent("정상 수정 됩니다.[수정]");
//		bvo.setWriter("user01");
//		bvo.setBoardNo(7);
//		if (mapper.updateBoard(bvo) == 1) {
//			sqlSession.commit();
//		};
		
		// 삭제 
//		BoardVO bvo = new BoardVO();
//		bvo.setBoardNo(8);
//		if (mapper.deleteBoard(bvo.getBoardNo()) == 1) {
//			sqlSession.commit();
//		};
		
		// 단건 조회 
	
//		if (mapper.selectBoard(4) == null) {
//			System.out.println("조회 된 내용이 없습니다.");
//		}else {
//			BoardVO bvo = mapper.selectBoard(4);
//			System.out.println(bvo.toString());
//		}
		
		
		// 전체 목록 출력
//		List<BoardVO> list = mapper.boardList(); // 목록이라서 List로 반환 
//		
//		for(BoardVO bvo2 : list) {
//		System.out.println(bvo2.toString());
//		}
//		
		// 페이징 해서 전체 목록 출력 
//		List<BoardVO>plist = mapper.listWithPage(1);
//		for (BoardVO bvo : plist) {
//			System.out.println(bvo.toString());
//		}
		
		SearchDTO search = new SearchDTO();
		search.setKeyword("minijurie");
		search.setSearchCondition("W");
		search.setPage(1);
		List<BoardVO>alist = mapper.listWithPage(search);
		for (BoardVO bvo : alist) {
			System.out.println(bvo.toString());
		}
		
		
	}// close main
}// close class
