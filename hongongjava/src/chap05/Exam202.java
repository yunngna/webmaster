package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		
//		String args1 = args[1];
//		System.out.println(args1); // string 문자 형태이다. 
//		//계산시에는  int 로 변경
//		int args2 = Integer.parseInt(args1);
//		int sum = args2 + 100;
//		
		
		// 배열을 생성하는 방법
		int[] scores = { 83, 90, 87 };

		// 배열을 이용하는 방법
		System.out.println("scores[0]:" + scores[0]);
		System.out.println("scores[1]:" + scores[1]);
		System.out.println("scores[2]:" + scores[2]);

		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합:" + sum);
		double avg = (double) sum / scores.length;
		System.out.printf("평균: %.2f\n", avg);

		// 배열의 1에서 100까지의 임의의 수 10개 (random()) 저장
		// 배열의 합과 평균 (소수 첫째 자리까지 나타냄)
		// 최댓값, 최소값 구하기

		// 배열 생성
		
		// 배열 생성 방법
		//1. 데이터 넣으며 생성
//		int[]num1 = {10,20,30,40};
		//2. 데이터 넣기 전에 배열의 크기 지정,타입 지정 하면서 형성 
//		int[]num2 = new int[5];
		
		int[] numbers = new int[10];
		for (int i = 0; i < 10; i++) {
			int number = (int) (Math.random() * 100) + 1;
			numbers[i] = number;
//			System.out.print(number + " "); // 방법1) 배열의 데이터 보기 
		}
//		System.out.println(numbers); 배열의 경우 배열 데이터가 출력되는 것이 아니라 주소가 출력된다. 
		
		System.out.println(Arrays.toString(numbers)); //방법3) 배열을 가져오는 클래스(array) 사용하기 => string 으로 가져와줘 

		// 배열 이용, 합, 평균, 최대, 최솟값
		int sum1 = 0;
		int maxnum = 0;
		int minnum = numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
//			System.out.print(numbers[i] + " "); 방 법2) 배열의 데이터 보기 
			sum1 += numbers[i];
			
			if (maxnum < numbers[i]) {
				maxnum = numbers[i];
			}
			if (minnum > numbers[i]) {
				minnum = numbers[i];
			}
		}
		System.out.printf("총합:%d | 최대값:%d | 최솟값:%d | ",sum1, maxnum ,minnum);
		double avg1 = (double) sum1 / numbers.length;
		System.out.printf("평균:%.1f", avg1);

	}// close main
}// close class
