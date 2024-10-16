package 권나윤;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) { 
		// 2024.09.26 과제
		// 1. 배열에 저장 된 값들의 합, 최대값, 최소값 구하기
		// ① 배열 값 : 1에서 100까지의 난수(Math.random()) 10개 배열에 저장
		// ② 배열 값 출력
		// ③ 배열 값의 합계, 최대값, 최소값 출력
		System.out.println("Q1");

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			int rn = (int) (Math.random() * 100) + 1;
			arr[i] += rn;
		}
		System.out.println(Arrays.toString(arr));

		int sum = 0;
		int max = 0;
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			if (max < arr[i]) {
				max = arr[i];
			}

			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.printf("합계는 %d , 최대값은 %d, 최소값은 %d", sum, max, min);
		System.out.println();

		// 2. 2차원 배열 출력
		// • 배열= {{1,2,3}, {1,2}, {1}, {1,2,3}};
		System.out.println("----------------------------------------");
		System.out.println("Q2");
		
		int[][] nums = { { 1, 2, 3 }, { 1, 2 }, { 1 }, { 1, 2, 3 } };
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.printf("%2d", nums[i][j]);
			}
			System.out.println();
		}

		// 3. 현재 관객의 수 출력
		// • 관객이 있는 좌석은 1, 없는 좌석은 0 : 난수 이용
		// • 극장의 자리는 1줄에 10좌석씩 3줄
		// ① 3행 10열의 배열에 0 또는 1 저장 -> 값 출력
		// ② 관객 수 계산하기 -> 현재 관객 수는 00명
		System.out.println("----------------------------------------");
		System.out.println("Q3");

		int[][] seats = new int[3][10];
		int ppl = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				int zeroone = (int) (Math.random() * 2);
				seats[i][j] = zeroone;
				System.out.printf("%2d", seats[i][j]);
				if (seats[i][j] == 1) {
					ppl += 1;
				}
			}
			System.out.println();
		}
		System.out.println("현재 관객의 수는 " + ppl);

		// 4. 학생 별 평균 계산하기
		// • 학생 3명, 각 학생당 5번의 테스트 점수를 배열에 저장 (3행 5열)
		// • 50 <= 점수 <= 100 (성적 난수 발생)
		// • 학생 별 평균 계산 출력
		System.out.println("----------------------------------------");
		System.out.println("Q4");

		int[][] classroom = new int[3][5];

		for (int i = 0; i < classroom.length; i++) {
			int sums = 0;
			for (int j = 0; j < classroom[i].length; j++) {
				int score = (int) (Math.random() * 51) + 50;
				classroom[i][j] = score;
				System.out.printf("%d \t", classroom[i][j]);
				sums += classroom[i][j];
			}System.out.println();
			double avg = (double) sums / classroom[i].length;
			System.out.printf("%d 번 학생의 평균 = %.2f", i, avg);
			System.out.println();
		}

		// 5. 카드를 랜덤하게 선택하여 화면에 출력
		// • 배열 : {"Clubs", "Diamonds", "Hearts", "Spades"}
		// • 배열 : {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"}
		// • 각 카드를 랜덤하게 선택하는 코드 작성(5번)
		System.out.println("----------------------------------------");
		System.out.println("Q5");
		
		String[] cardname = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] cardnum = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		for (int i = 1; i <= 5; i++) {
			int rcardname = (int) (Math.random() * cardname.length);
			int rcardnum = (int) (Math.random() * cardnum.length);
			String stc1 = cardname[rcardname];
			String stc2 = cardnum[rcardnum];
			System.out.printf("%s의 %s\n", stc1, stc2);
		}

		// 6. 2차원 배열 만들기
		// • 3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화
		// • 5개의 정수 1을 랜덤하게 배치
		System.out.println("----------------------------------------");
		System.out.println("Q6");
		int[][] arr1 = new int[3][5];
		int numOnes = 5;
		int inOnes = 0;

		while (inOnes < numOnes) {
			int row = (int) (Math.random() * arr1.length);
			int col = (int) (Math.random() * arr1[row].length);
			if (arr1[row][col] == 0) {
				arr1[row][col] = 1;
				inOnes++;
			}
			if (inOnes > numOnes) {
				break;
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("%2d", arr1[i][j]);
			}
				System.out.println();
		}

	}// end main
}// end class