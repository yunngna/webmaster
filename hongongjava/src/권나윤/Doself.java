package 권나윤;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		// 1. 윤년 계산 프로그램
		//입력된 년도가 윤년인지 계산하는 프로그램 작성 [scanner, if ]
		//4로 나누어 떨어지고, 100으로 나누어 떨어지지 않으면 윤년
		//400으로 나누어 떨어지면 윤년
		
		
		Scanner scn = new Scanner(System.in);
		System.out.print("##년도 입력:");
		int year = Integer.parseInt(scn.nextLine());
		if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) {
			System.out.println(year + "년은 윤년입니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}
		
		//2. 동전 교환 프로그램
		//입력된 액수만큼 500원, 100원, 50원, 10원짜리 동전으로 교환해 주는 프로그램 작성
		//- 동전의 총개수는 최소화
		//- 고액의 동전 먼저 교환
		
		System.out.print("##교환할 금액:");
		int coins = Integer.parseInt(scn.nextLine());
		//500원짜리 
		int ohbeak = coins / 500;
		System.out.println("500원짜리 : " + ohbeak);
		int change = coins - (ohbeak * 500);
		
		int beakwon = change / 100;
		System.out.println("100원짜리 :" + beakwon);
		change = change - (beakwon*100);
		
		int ohship = change / 50;
		System.out.println("50원짜리 :" + ohship);
		change = change - (ohship*50);
		
		int ship = change / 10;
		System.out.println("10원짜리:" + ship);
		
		
		int chnmoney= (ohbeak * 500) + (beakwon*100) + (ohship*50) + (ship*10) ;
		
		System.out.println("교환 금액:" +  chnmoney + "원");
		System.out.println("남은 금액:" + (coins - chnmoney));
		
		
		
		
		
		//3. 숫자 추측 게임
		//• 1에서 100까지의 수를 발생 시키고 어떤 수인지 알아 맞히는 게임 프로그램 작성 [랜덤 수 발생, scanner, if ]
		
		int num = (int)(Math.random()*100)+1;

		while(true) {
			System.out.print("숫자 입력:");
			int figure = Integer.parseInt(scn.nextLine());
			
			if (num < figure) {
				System.out.println("down 하세요!");
				
				
			}else if(num > figure) {
				System.out.println("up 하세요!");
			
				
			}else if (num == figure) {
				System.out.println("축하합니다!!");
				break;
			}
		}
	
			
		
		
		//5. 섭씨-화씨 온도 변환 프로그램
		//• 섭씨 온도(C) = 5 / 9 * (F – 32 ) 
		//• 화씨 온도(F) = 9 / 5 * C + 32
		//1. 화씨 -> 섭씨 2. 섭씨 -> 화씨 3. 종료
		
		
		System.out.println("-----------------------------");
		System.out.println("1. 화씨 => 섭씨");
		System.out.println("2. 섭씨 => 화씨");
		System.out.println("3. 종료");
		System.out.println("-----------------------------");
		
		boolean run = true;
		
		while(run) {
			System.out.print("▶ 번호 선택:");
			int num1 = Integer.parseInt(scn.nextLine());
			switch(num1) {
				case 1 :
					System.out.print("▶ 화씨 온도 입력:");
					double degree1 = Double.parseDouble(scn.nextLine());
					double degree2 = 5.0 / 9.0 * ( degree1 - 32.0);
					System.out.printf("섭씨온도: %.6f", degree2);
					break;
				case 2 :
					System.out.print("▶ 섭씨 온도 입력:");
					degree2 = Double.parseDouble(scn.nextLine());
					degree1 = 9.0 / 5.0 *degree2 + 32.0 ;
					System.out.printf("화씨온도: %.6f", degree1);
					break;
				case 3 :
					run = false;
					break;
				default :
					System.out.print("선택이 잘못되었습니다.");
					break;	
			}System.out.println();
		}
		System.out.print("program end");
		
		//6. 가위,바위, 보 게임 프로그램
		//• 가위 바위 보 중에 하나를 선택하면, 컴퓨터가 생성한 난수값과 비교하여 누가 이겼는지 화면에 출력하는 프로그램 작성
		//• 2보다 큰 수 입력하면 game over 출력 => 종료
		
		int number = (int)(Math.random()*3)+0;
		System.out.println(number);
		
		while(true) {
			System.out.print("##가위(0) 바위(1) 보(2):");
			int game = Integer.parseInt(scn.nextLine());
			if (game >= 3) {
				break;
			} else if(game == 0 && number ==2 ) {
				System.out.printf("사람 %d, 컴 %d 이겼음\n",game,number);
			}else if (game > number) {
				System.out.printf("사람 %d, 컴 %d 이겼음\n",game,number);
			}else if (game == number) {
				System.out.printf("사람 %d, 컴 %d 비겼음\n",game,number);
			}else {
				System.out.printf("사람 %d, 컴 %d 졌음\n",game,number);
			}
		}
		System.out.print("game over\n");
		
	
		//7. 3, 6, 9게임 프로그램
		//• 1~50까지 3, 6, 9가 들어가는 숫자마다 3, 6, 9가 들어가 있는 개수 만큼 ♥10
		String samukgu ="";
		
		for(int i=1; i<=50; i++) {
			if (i%10==3 || i%10==6 || i%10==9) {
				samukgu += "♥";
			}if (i/10==3 || i/10==6 || i/10==9) {
				samukgu += "♥";
			}if (samukgu.equals("")) {
				samukgu += String.valueOf(i);
			}
			
			if(i % 10 == 0) {
				System.out.println(samukgu + "\n");
			}else {
				System.out.print(samukgu+ "\t");
			}
			samukgu ="";
			
		}
	
		scn.close();



	}

}
