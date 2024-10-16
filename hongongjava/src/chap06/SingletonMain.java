package chap06;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글톤 사용시 객체 생성 필요 불가  -> 메소드 호출 해서 객체를 받아와야 한다.
		
		Singleton st1 = Singleton.getInstance(); // 객체를 생성해서 사용하는 것이 아니라 getInstance() 메소드를 불러서 사용한다. 
		Singleton st2 = Singleton.getInstance();
		
		if (st1 == st2) {
			System.out.println("같은 Singletone 객체 입니다.");
		} else {
			System.out.println("다른 Singletone 객체 입니다.");
		}
		
		System.out.println(st1.name); // 이름 변경 전 
		st1.name = "아무개"; // 같은 객체이기 때문에 st2 출력시 이름이 변경 된다. 
		System.out.println("st1이름 : "+ st1.name); // 이름 변경 후
		System.out.println("st2이름 : "+ st2.name);// 이름 변경 후
		System.out.println();
		
		
		//p307 Q3 싱글톤 활용
		//객체 생성 대신 getInctance 메서드 가져오기
		ShopService ss1 = ShopService.getInctance();
		ShopService ss2 = ShopService.getInctance();
		
		if (ss1 == ss2) {
			System.out.println("같은 ShopService객체 입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	
		
	}

}
