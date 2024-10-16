package chap06;

public class Library {
	// 책 제목, 도서번호, 도서 가격 
	// 외부에서 필드 접근 막고 getter, setter 사용해서 접근 
	
	// 필드
	private String booknm;
	private String booknb;
	private int bookpc;
	
	
	//생성자
	Library (){}
	
	Library (String booknm, String booknb, int bookpc){
		this.booknm= booknm;
		this.booknb=booknb;
		this.bookpc=bookpc;	
	}
	

	//메서드
	public String getBooknm() {
		return booknm;
	}


	public void setBooknm(String booknm) {
		this.booknm = booknm;
	}


	public String getBooknb() {
		return booknb;
	}


	public void setBooknb(String booknb) {
		this.booknb = booknb;
	}


	public int getBookpc() {
		return bookpc;
	}


	public void setBookpc(int bookpc) {
		this.bookpc = bookpc;
	}
	
	
	
}	
