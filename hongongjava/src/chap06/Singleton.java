package chap06;

public class Singleton {
	// 전체 프로그램에서 하나의 객체만 존재하게 하는 코딩 기법 
	// 생성자 접근 불가 & 필드 접근 불가 
	// class로 접근 해야 한다. (정적 필드,메서드)
	
	// 필드
	private static Singleton st = new Singleton();
	String name = "홍길동"; // 인스턴스 필드 
	
	// 생성자
	private Singleton() { }
	// 메소드 : 외부로 객체 전달
	static Singleton getInstance() {
		return st;
	}
}
