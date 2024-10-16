package chap06;

public class BoardMain {

	public static void main(String[] args) {
		// 객체 생성
		Board board1 = new Board ("제목1","내용1");
		Board board2 = new Board ("제목2","내용2","저자2");
		Board board3 = new Board ("제목3","내용3","저자3","2021-09-27");
		Board board4 = new Board ("제목4","내용4","저자4","2021-09-27",123);
		Board board5 = new Board();
		
		//필드 변경 
		board5.title = "제목5";
		board5.hitcount = 999;
		
		//필드 표시
		System.out.printf("%s | %s | %s | %s | %d\n",board1.title, board1.content, board1.writer,board1.date,board1.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",board2.title, board2.content, board2.writer,board2.date,board2.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",board3.title, board3.content, board3.writer,board3.date,board3.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",board4.title, board4.content, board4.writer,board4.date,board4.hitcount);
		System.out.printf("%s | %s | %s | %s | %d",board5.title, board5.content, board5.writer,board5.date,board5.hitcount);
		
	}

}
