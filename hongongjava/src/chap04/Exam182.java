package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
	//Q4 방정식 4x + 5y = 60 의 모든 해 (x,y) 형태로 출력 ( 단, x,y 는 10이하 자연수)
		for (int x=1; x<=10; x++) {
			for (int y=1; y<=10; y++) {
				if ((4 * x)+(5 * y) == 60 ) {
					System.out.printf("x와 y의 해는 (%2d,%2d)\t\n",x,y);
				}
			}
		}
	//Q5 
		//방법1
		for(int i=1; i<=4; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//방법2 (println가 가능해서 java에서만 가능)
		String star = "";
		for(int i=1; i<=4; i++) {
			star += "*";
			System.out.println(star);
		}
		
		
		//Q6
		//방법1
		String star1 = "";
		for(int i=1; i<=4; i++) {
			star1 += "*";
			System.out.printf("%4S\n",star1);
		}
		
		//방법2
		String star2 = "";
		String star3 = "";
		for (int i=1; i<=4; i++) {
			star2 += "*";
			for (int j=i; j<=3; j++) {
				star3 += " ";
			}
			System.out.println(star3 + star2);
			star3 = ""; // 별의 경우에는 도는 회차에 별이 누적 되게 해주고, 공백의 경우 한바퀴 돌고 비워준다.
		}
		
		
		//Q7
		boolean run = true;
		int balance = 0;
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 예금  | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택>");
			int selNo = Integer.parseInt(scn.nextLine());
			
			switch(selNo) {
			case 1 :
				System.out.println("예금액>");
				int deposit = Integer.parseInt(scn.nextLine());
				balance += deposit;
				break;
			case 2:
				System.out.println("출금액>");
				int withdraw = Integer.parseInt(scn.nextLine());
				if (balance < withdraw) {
					System.out.println("출금 불가");
					System.out.println("출금 가능 금액=" + balance);
				}else {
					balance -= withdraw;
				}
				break;
			case 3 :
				System.out.println("잔고>" + balance);
				break;
			case 4 :
				run = false;
				break;
			default:
				System.out.println("선택이 잘못되었습니다.");
				break;
				}			
		}
		System.out.println("프로그램 종료");
		
		scn.close();
		
		
		
		
		
	}//end main

}//end class
