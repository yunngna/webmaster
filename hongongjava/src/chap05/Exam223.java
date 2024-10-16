package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		// 확인문제Q6
		boolean run = true;
		int studentnum = 0;
		int[] scores = null;

		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료  ");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1:
				System.out.print("학생수> ");
				studentnum = Integer.parseInt(scn.nextLine());
				if (studentnum == 0) {
					System.out.println("값을 입력하세요");
				} else {
					scores = new int[studentnum];
				}
				break;
			case 2:
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores [" + i + "] >");
					int selectScore = Integer.parseInt(scn.nextLine());
					scores[i] += selectScore;
				}
				break;
			case 3:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("score [%d] > %d\n", i, scores[i]);
				}
				break;
			case 4:
				int sum = 0;
				int maxgrade = 0;
				int mingrade = scores[0];

				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (maxgrade < scores[i]) {
						maxgrade = scores[i];
					}
					if (mingrade > scores[i]) {
						mingrade = scores[i];
					}
				}
				double avg = (double) (sum / scores.length);

				System.out.println("최고 점수:" + maxgrade);
				System.out.println("최저 점수:" + mingrade);
				System.out.printf("평균 점수: %.2f", avg);
				System.out.println();
				break;
			case 5:
				run = false;
				break;

			}
		}
		System.out.println("프로그램 종료");

		scn.close();

	}// end main

}// end class
