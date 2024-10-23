package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
//		SqlSession sqlSession = DataSource.getInstance().openSession();
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // mapper 가져오기
		
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
		
//		SearchDTO search = new SearchDTO();
//		search.setKeyword("minijurie");
//		search.setSearchCondition("W");
//		search.setPage(1);
//		List<BoardVO>alist = mapper.listWithPage(search);
//		for (BoardVO bvo : alist) {
//			System.out.println(bvo.toString());
//		}
		
		
		// 댓글 테스트
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		//댓글 추가
		ReplyVO rvo = new ReplyVO();
//		rvo.setReply("댓글입니다1");
//		rvo.setReplyer("minijurie");
//		rvo.setBoardNo(404);
//		if (mapper.addReply(rvo) == 1) {
//			sqlSession.commit();
//		};
		
		//댓글 삭제 
//		rvo = new ReplyVO();
//		rvo.setReplyNo(6);
//		if (mapper.deleteReply(rvo.getReplyNo()) == 1) {
//			sqlSession.commit();
//		};
		
		//댓글 전체보기 
		List<ReplyVO> list = mapper.selectList(404); // 목록이라서 List로 반환 		
		for(ReplyVO rpv : list) {
		System.out.println(rpv.toString());
		}
		
		//댓글 번호로 단건 조회 
//		if (mapper.selectReply(5) == null) {
//			System.out.println("조회 된 내용이 없습니다.");
//		}else {
//			rvo = mapper.selectReply(5);
//			System.out.println(rvo.toString());
//		}
		
		
	}// close main
}// close class
