package chap04;

public class Exam162 {

	public static void main(String[] args) {
		//주사위 2개를 던져서 합이 5가 되면 종료  - 게임 오버(Game over) 출력 
		// 만약 5가 아니면 (1,3) 주사위 눈 표시 
		// 몇번 만에 나왔는지? count 사용 해야 하며 변수가 반복 될때 마다 초기화 안되게 하기 위해서 while문 밖에 변수 선언 해준다. 
		
		int cnt = 0;
		while(true) {
		int dice1 = (int)(Math.random() *6) + 1; 
		int dice2 = (int)(Math.random() *6) + 1;
		cnt++;
		System.out.printf("(%d,%d)\t",dice1,dice2);
		
		if (dice1 + dice2 == 5) {
			System.out.println("\n" + cnt + "번 게임 오버(Game over)");
			break;
			}
		
		}
		
		
		//주사위 눈이 1 이면 1등  ~ 6이면 6등이라고 출력
		int dice3= (int)(Math.random()*6)+1;
		//if else  구문
		if(dice3 == 1) {
			System.out.println("1등");
		}else if (dice3 ==2) {
			System.out.println("2등");
		}else if (dice3 ==3) {
			System.out.println("3등");
		}else if (dice3== 4) {
			System.out.println("4등");
		}else if (dice3 == 5) {
			System.out.println("5등");
		}else{
			System.out.println("6등");
		}
		//switch 구문
		switch(dice3) {
			case 1 : System.out.println("1등");
			break;
			case 2 : System.out.println("2등");
			break;
			case 3 : System.out.println("3등");
			break;
			case 4 : System.out.println("4등");
			break;
			case 5 : System.out.println("5등");
			break;
			default: System.out.println("6등");
		}
		// 한문장으로 적기
		System.out.println(dice3 + "등");
		
		
		//50-100 까지 수 발생  (switch) [곱수 = 최종값 - 초기값 + 1]
		// 90 이상이면 A , 80 이상이면 B , 70이상이면 C, .... 60이상 이면 D , 나머지 F
		// 연산을 하게 되면 자동으로 int로 변환
		
		int rannum = (int)(Math.random() * 51 ) + 50;
		System.out.println("수는:" + rannum);
		//방법1
		switch(rannum / 10){
			case 10 : 
			case 9  : System.out.println("A");
			break;
			case 8  : System.out.println("B");
			break;
			case 7  : System.out.println("C");
			break;
			case 6  : System.out.println("D");
			break;
			default : System.out.println("F");
			break;
		}
		//방법2
		switch(rannum - (rannum % 10)){
		case 100 : 
		case 90  : System.out.println("A");
		break;
		case 80  : System.out.println("B");
		break;
		case 70  : System.out.println("C");
		break;
		case 60  : System.out.println("D");
		break;
		default : System.out.println("F");
		break;
	}

	}

}
