package 도서관리;
//book 의 정보를 가져와서 정보를 담아 놓기 위한 class

public class Book {
	//필드는 외부 접근 막기 - getter. setter 사용 
	private String title;
	private String writer;
	private int price;
	private String bnum;
	
	
	//생성자
	Book (){}
	
	Book (String writer){
		this.writer=writer;
	}
	
	Book (String title, String writer, int price, String bnum){
		this.title= title;
		this.writer= writer;
		this.price = price;
		this.bnum= bnum;
	}
	
	
	//메소드
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	
	@Override
	public String toString() {
		return title + "\t" + writer + "\t" + price + "\t" + bnum;
	}

}
