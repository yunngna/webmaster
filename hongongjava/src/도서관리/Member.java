package 도서관리;

import java.util.Date;

public class Member {
	//필드 ( 필드 이름을 적을때 두단어 이상을 조합 할때 sql 에서는 _ 로 구분하지만 java에서는 두번째 단어 대문자!!!!!!!
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String reponsibility;
	private Date creationDate;
	//생성자
	Member(){}
	
	Member(String memberId, String password, String memberName, String phone){
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phone = phone;
	}
	
	//메소드
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReponsibility() {
		return reponsibility;
	}
	public void setReponsibility(String reponsibility) {
		this.reponsibility = reponsibility;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	//생성 날짜 문자로 변환 
	public String toDate() {
		String creatDate = creationDate.toString();
		return creatDate;
		
	}
	
	//문자로 전환된 날짜 출력
	public void print() {
		System.out.printf("memberId=%8s \t password=%10s memberName=%5s \t phone=%10s \t reponsibility=%5s \t creationDate= %s \n",memberId,password,memberName,phone,reponsibility,toDate()); 
	}
	
	// toString overide
//	@Override
//	public String toString() {
//		return "Member [memberId=" + memberId + ", password=" + password + ", memberName=" + memberName + ", phone="
//				+ phone + ", reponsibility=" + reponsibility + ", creationDate=" + creationDate + ", toString()="
//				+ super.toString() + "]";
//	}
	
	
	
	
	

}
