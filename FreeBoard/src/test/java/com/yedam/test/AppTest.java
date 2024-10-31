package com.yedam.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.CalendarVO;

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
//		SqlSession sqlSession = DataSource.getInstance().openSession();
//		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
		//댓글 추가
//		ReplyVO rvo = new ReplyVO();
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
//		List<ReplyVO> list = mapper.selectList(404); // 목록이라서 List로 반환 		
//		for(ReplyVO rpv : list) {
//		System.out.println(rpv.toString());
//		}
		
		//댓글 번호로 단건 조회 
//		if (mapper.selectReply(5) == null) {
//			System.out.println("조회 된 내용이 없습니다.");
//		}else {
//			rvo = mapper.selectReply(5);
//			System.out.println(rvo.toString());
//		}
		
		//사용자별 게시글 수 조회 (이름 , 아이디 ,게시글 수 )
//		BoardService svc = new BoardServiceImpl();
//		List<Map<String,Object>> result = svc.countByWriter();
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(result);
//		
//		System.out.println(json);
		
		
		
		//캘린더 추가 
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper mapper =sqlSession.getMapper(MemberMapper.class);
//		
//		CalendarVO event = new CalendarVO();
//		event.setTitle("lunch");
//		event.setStartD("2024-10-28T12:00:00");
//		event.setEndD("2024-10-28T14:00:00");
//		if (mapper.addEvent(event) == 1) {
//			sqlSession.commit();
//		};
		
		//캘린더 조회
		MemberService svc = new MemberServiceImpl();
		
		List<Map<String,Object>> result = svc.eventList();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		System.out.println(json);
		
		//캘린더 삭제
		CalendarVO cvo = new CalendarVO();
		cvo.setTitle("소풍2");
		cvo.setStartDate("2024-10-23");
		cvo.setEndDate("2024-10-25");
		
		if(svc.removeEvent(cvo)) {
			System.out.println("성공");
		}
		

		
	}// close main
}// close class
