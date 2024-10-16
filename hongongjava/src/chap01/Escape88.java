package chap01;

public class Escape88 {
	//void = return 값 없음
	//static = 객체 없이 사용 가능
	//string[]args = 값은 배열타입
	//ctrl + alt +방향키 = 복사

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는\"개발자\"입니다");
		System.out.print("봄\\여름\\가을\\겨울");
		
		//p91 예제 "시작합니다" 출력하기
		boolean stop = true;
		if (!stop) {
			System.out.println("시작합니다.");
		}else {
			System.out.println("중지합니다.");
		}
		
		//P103 type 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
//		byte byteValue3 = byteValue1 + byteValue2;  오류 발생
		
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
//		char charValue3 = charValue1 + charValue2; 오류 발생
		
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + intValue2);
		
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		
		int intValue5 = 10;
//		int intValue6 = 10 / 4.0; 오류 발생
		
		double doubleValue = intValue5/ 4.0;
		System.out.println(doubleValue);
		
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		//P106 문자열 -> 숫자열 변환, 숫자열-> 문자열로 변환
		
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 : " + value1);
		System.out.println("value1 : " + (value1 + 100));
		
		System.out.println("value2 : " + value2);
		System.out.println("value2 : " + (value2 + 100));
		
		System.out.println("value3 : " + value3);
		
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1:" + str1 );
		System.out.println("str1:" + ( str1 + 100 ));
		
		System.out.println("str2:" + str2 );
		System.out.println("str2:" + ( str2 + 100 ));
		
		System.out.println("str3:" + str3 );
		
		//P109 Q5 B가 출력이 되도록 하기
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		
		System.out.println(c2);	
		//b의 코드값 출력
		System.out.println((int)c2);
		
		//P109 Q6
		int n1 = 5;
		int n2 = 2;
		int divide = n1 / n2;
		System.out.println(divide);
		
		//P109 Q7
		int n3 = 5;
		int n4 = 2;
		double divide1 = (double)n3/(double)n4;
		System.out.println(divide1);
		
		//p109 Q8
		double var1= 3.5;
		double var2 = 2.7;
		int plus = (int)(var1 + var2);
		System.out.println(plus);
		
		
		//p110 Q9
		long su1 = 2L;
		float su2 = 1.8f;
		double su3 = 2.5;
		String su4 = "3.9";
		int sum1 = (int)((int)su1 + (int)su2 + su3 + Double.parseDouble(su4));
		System.out.println(sum1);
		
		System.out.printf("값은 %d 내이름은 %s 더블은 %.1f\n",sum1, su4 , su3);
		// 소수 첫번째 자리 까지 포함 : .1 , 그리고 printf 의 경우 줄바꿈이 안되기 때문에 다음 결과 값이 옆에 나타난다. 그래서 \n으로 줄바꿈 해줘야 한다.
		
		//p110 Q10
		String munsa1 = 2 + 3 + "";
		String munsa2 = 2 + "" + 3;
		String munsa3 = "" + 2 + 3;
		System.out.println(munsa1);
		System.out.println(munsa2);
		System.out.println(munsa3);
		
		//p110 Q11
//		byte value = ("10");
//		int value = ("1000");
//		float value = ("20.5");
//		double value = ("3.14159");
	
		
	}//end main

}//end class
