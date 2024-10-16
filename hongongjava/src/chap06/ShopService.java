package chap06;

public class ShopService {
	//p307 Q3 싱글톤 기법 사용 (= 정보 은닉, 캡슐화)
	
	//필드 : 자신의 객체 저장
	private static ShopService ss = new ShopService();
	
	//생성자 : 외부 접근 막아야 함
	private ShopService () {} // 기본 생성자 (private)
	
	//메서드 : 외부로 객체 전달  ( 외부에서 접근 해야 하기  때문에 private를 붙이면 안된다)
	static ShopService getInctance() {
		return ss;
	}

}
