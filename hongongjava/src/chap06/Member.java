package chap06;

public class Member {
	//1. 필드 생성 
	String name ;
	String id;
	String password;
	int age;
	
	//2. 생성자 생성
	Member(){} // 기본 생성자 명시적으로 형성
	Member (String name, String id){
		this.name = name;
		this.id = id;
	}
	//3. 메서드 생성
	
	
	//여기서 Member class는 name, id, password, age라는 속성을 가진 class
}
