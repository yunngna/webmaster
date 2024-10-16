package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50 에서 100까지 3의 배수 합 구하기 
		// 3의 배수 출력 , 마지막에 3의 배수 합 출력
		// 3의 배수 갯수 출력
		
		int sum = 0;
		int cnt= 0;
		for (int i=50; i<=100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + "\t");
				sum += i;
				cnt++;
			}
		}
		System.out.println(); // 줄바꾸기 할때 그냥 빈 출력문 넣어줘도 된다
		System.out.printf("3의 배수의 합은 %d 이고, 3의 배수의 갯수는 %d 이다.",sum,cnt);
		
		//1에서 n까지의 합이 300이 넘는 순간 n 값 구하기. 
		//7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기 
		//while 문 사용 
		
		// 방법 1 : if 사용 안하는 방법 
		int su = 0;
		sum = 0;
		
		while (sum < 300) {
			su += 7;
			sum += su;
		}
		System.out.println();
		System.out.println("7의 배수는 = " + su);
		System.out.println("7의 배수 합은 = " + sum);
		
		
		// 방법 2 : while 의 true 사용 
		while (true) {
			su +=7;
			sum += su;
			if (sum >= 300) break;
		}
		System.out.println();
		System.out.println("7의 배수는 = " + su);
		System.out.println("7의 배수 합은 = " + sum);
		
		//방법3 
		while (true) {
			su++;
			if(su % 7 == 0) {
				sum += su;
				if (sum >= 300) break;
			}
		}
		System.out.println();
		System.out.println("7의 배수는 = " + su);
		System.out.println("7의 배수 합은 = " + sum);
			
		//중첩 for 문 구구단 출력
		for (int i=2; i <=9; i++ ) {
			System.out.println("========" + i + "단" + "========");
			for (int j=1; j<=9; j++) {
				System.out.printf(" %d x %d = %02d\n" , i, j, (i*j));
				//출력시 0 으로 채우려면 0 적어주고 자리값 지정은 자리값 만큼 숫자 적어준다.
			}
		}
		
		for (int i=2; i <=9; i++ ) {
			System.out.printf("%3d단\t",i);
			}
		System.out.println();
			for (int j=1; j<=9; j++) {
				for (int k=2; k<=9; k++ ) {
					System.out.printf("%dx%d=%2d\t", k, j, (k*j));
				}
				System.out.println();
			}
		
		
	}//end main

}//end class
