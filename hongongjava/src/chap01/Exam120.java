package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		// 문제1 : 출력문 연습
		//P120 확인 문제 Q1
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 ="123", tel3 = "4567";
		
		System.out.println("이름:" + name);
		System.out.print("나이:" + age + "\n");
		System.out.printf("전화: %s - %s - %s \n",tel1,tel2,tel3);
		
		//Q2
		Scanner scn = new Scanner(System.in);
		
		System.out.print("첫번째 수:");
		String strNum1 = scn.nextLine();
				
		System.out.print("두번째 수:");
		String strNum2 = scn.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		
		System.out.println("덧셈 결과:" + result);
		
		//Q3
		System.out.print("이름 : ");
		String name1 = scn.nextLine();
		
		System.out.print("주민번호 앞 6자리 : ");
		String personalNum = scn.nextLine();
		
		System.out.print("전화번호(중간4자리) : ");
		String tell1 = scn.nextLine();
		
		System.out.print("전화번호(끝4자리) : ");
		String tell2 = scn.nextLine();
		
		
		
		System.out.println("1. 이름:" + name1);
		
		int pn = Integer.parseInt(personalNum);
		System.out.println("2. 주민번호 앞 6자리:" + pn);
		
		int tp1 = Integer.parseInt(tell1);
		int tp2 = Integer.parseInt(tell2);
		
		System.out.printf("3. 전화번호: 010 - %d - %d \n", tp1,tp2 );
		
		
		//두수를 입력 받아 -> 큰 수 - 작은수 
		System.out.print("첫번째 수>");
		String nums1 = scn.nextLine();
		
		System.out.print("두번째 수>");
		String nums2 = scn.nextLine();
		
		int innum1= Integer.parseInt(nums1);
		int innum2= Integer.parseInt(nums2);
		
		if (innum1 >= innum2) {
			System.out.print( "두수의 차는:" + (innum1-innum2));		
		}else{
			System.out.print("두수의 차는:" + (innum2 - innum1));
		}
	
		
		
		
		
		
		
		scn.close();
		
	
		
		
		
		
	}//end main

}//end class
