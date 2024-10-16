package javadb;

import java.sql.Date; // sql 형식으로 가져와야 데이터 타입이다. 

	public class Board {
		//필드
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	
	
	
	//메소드 
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	@Override
		public String toString() {
			return bno + "\t" + btitle + "\t" + bcontent + "\t" + bwriter + "\t" + bdate;
		} // 출력시 주소가 아니라 내용이 출력되도록 toString override해준다. 
	
	
	
	
}
