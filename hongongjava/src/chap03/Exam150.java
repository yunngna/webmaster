package chap03;

import java.util.Scanner;

public class Exam150 {

	public static void main(String[] args) {
		//P150 Q4
		int pencils = 534;
		int students = 30;
		
		int pencilPerStudent = ( pencils/students);
		System.out.print(pencilPerStudent +"\n");
		
		int pencilsLeft = (pencils % students);
		System.out.print(pencilsLeft + "\n");
		
		
		//P150 Q5
		int var1= 5;
		int var2= 2;
		double var3 = (double)var1/var2;
		int var4 = (int)(var3 *var2);
		System.out.println(var4);
		
		//P150 Q6
		int value = 356;
		System.out.println ( value - 56 );
		
		//P150 Q7
		float num1 = 10f;
		float num2 = num1/100;
		if (num2 == 0.1) {
			System.out.println("10%입니다");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		System.out.println(num2);
		
		//P150 Q8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		
		double area = (lengthTop + lengthBottom)*height/2;
		System.out.println(area);
		
		//P150 Q9 
		
		Scanner scn = new Scanner (System.in);
		System.out.print("첫번째 수>");
		String strNum1 = scn.nextLine();
		
		System.out.print("두번째 수>");
		String strNum2 = scn.nextLine();
		
		double number1 = Double.parseDouble(strNum1);
		double number2 = Double.parseDouble(strNum2);
		
		double result = number1/number2;
		
		if (num2 != 0.0) {
			System.out.printf("첫번째 입력 수: %f 두번째 입력 수: %f 나눈 값:%f \n ",number1,number2,result);
		}else {
			System.out.print("결과: 무한대");
		}
		
		//P150 Q11
		System.out.print("아이디:");
		String id = scn.nextLine();
		
		System.out.print("패스워드:");
		String password = scn.nextLine();
		int pw = Integer.parseInt(password);
		
		if (id.equals("java")) {
			if (pw == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패 : 패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패 : 아이디 존재 하지 않음");
		}
		
		
		
		
		
		scn.close();
		
		//P150 Q10
		int radius = 10;
		int ban =3;
		int jirum = 14;
		
		double extent = radius * radius *(Double.parseDouble(ban + "." + jirum));
		System.out.print(extent);
		
		
		
		

	}//end main

}//end class
