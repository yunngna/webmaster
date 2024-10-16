package chap06;

public class MemberMain {
	public static void main(String[] args) {
		
		//객체 만들기
		Member member = new Member();
		Member member2 = new Member("홍길동","hong");
		
		//객체 사용 
		//필드값 읽기
		System.out.println(member.name);
		System.out.println(member.id);
		System.out.println(member.password);
		System.out.println(member.age);
		
		System.out.println("이름:" + member2.name +" " + "아이디:"+member2.id);
		
		//필드값 수정
		member.name = "최하얀";
		member.age = 23;
		System.out.println("수정된 이름:"+ member.name);
		System.out.println("수정된 나이:"+ member.age);
	}
}


