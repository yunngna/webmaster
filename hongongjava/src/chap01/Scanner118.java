package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin;
		
		//문자열
		System.out.print("문자열 입력>");
		strin = sc.nextLine();
		System.out.println("입력 받은 문자열:" + strin);
		
		//데이터가 힙에 저장되고 힙의 주소가 입력된 객체는  참조 타입 이기 때문에 == 을 사용해서는 안된다. 그래서 equals를 사용해줘야 한다. 
//		if(strin == "q") {
//			System.out.print("q입력됨");
//		}else {
//			System.out.print("같지 않음");
//		}
		
		if(strin.equals("q")) {
			System.out.print("q입력됨");
		}else {
			System.out.print("같지 않음");
		}
		
		//숫자열
		System.out.print("숫자 입력 >");
		int valInt = sc.nextInt();
		System.out.println("입력 받은 숫자열 :" + valInt);
//		strin = sc.nextLine();
		
		
		//nextInt로 인해서 남은 공백을 다 처리 해 버려서 "문자열 입력>입력받은 문자열" 로 표시된다. 그러므로 앞에  "strin = sc.nextLine();" 추가 해줘야 한다. 
//		System.out.print("문자열 입력>");
//		strin = sc.nextLine();
//		System.out.println("입력 받은 문자열:" + strin);
		
		//nextline 한 후 정수 변환
		System.out.print("숫자 입력>");
		valInt = Integer.parseInt(sc.nextLine());
		System.out.println("입력 받은 숫자열:" + (valInt + 100));
		
		
		sc.close();
	
		
	

	}

}
