package chap07;

public class Controller {
	//필드
	public MemberService service;
	//생성자
	//메서드
	public void setService(MemberService service) {
		this.service = service;
	}
	
	
	//메인 메소드 생성 
	public static void main(String[] args) {
		
		Controller ct = new Controller();
		
		
		ct.setService(new MemberService());
		ct.service.login();
		
		ct.setService(new AService());
		ct.service.login();
	}
	
	
}
