package chap06;

public class MemberService {
	//P290 확인 문제 Q3
	//객체 생성 
	
	
	//생성자 생성
	//메서드 생성
	boolean login(String id ,String password) {
		if (id == "hong" && password == "12345") {
			return true;
		}else {
			return false;
		}
	}
	void logout (String id) {
		System.out.println("로그아웃 되었습니다.");
	}

}
