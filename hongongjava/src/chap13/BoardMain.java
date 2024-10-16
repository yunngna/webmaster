package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		
		List<Board> list = new Vector<Board>();
		
		//Board 타입으로 생성자를 통해서 객체를 새로 생성해준다. 
		list.add(new Board ("제목1","내용1","글쓴이1"));
		list.add(new Board ("제목2","내용2","글쓴이2"));
		list.add(new Board ("제목3","내용3","글쓴이3"));
		list.add(new Board ("제목4","내용4","글쓴이4"));
		list.add(new Board ("제목5","내용5","글쓴이5"));
		
		//삭제 
		list.remove(2);
		list.remove(3);
		
		//for문 사용해서 전체 내용 출력 
		for (int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
		System.out.println();
		
		//향상된 for 문 사용 
		for (Board ctt : list) {
			System.out.println(ctt.subject + "\t" + ctt.content + "\t" + ctt.writer);
		}
		//해시코드
		Board bd = new Board("제목","내용","글쓴이");
		System.out.println(bd); //객체의주소값 
		System.out.println(bd.hashCode());// 순수하게해시코드 (int 타입이다)
		System.out.println(bd.toString()); // 객체의 주소값을 문자로 출력 
	
		// Board 에 
		
		//메소드
//		@Override
//		public String toString() {
//			return subject + ":" + content + ":" + writer;
		// 추가함으로서 println 에 객체참조 변수가 들어오면 toString() 이 자동으로 실행 되게되어 있다. 
		}

	}

