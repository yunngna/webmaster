package chap05;



public class Exam214 {

	public static void main(String[] args) {
		//2차원배열 
		int[][] scores= {
				{10,20,30}, //  행 2개 열 3개
				{40,50,60}
		};
		for (int i=0; i<scores.length; i++) { //행 for 문
			for (int j=0; j <scores[i].length; j++) { // 배열[i] 를 하나의 배열로 생각하면 열의 갯수는 배열의 길이랑 동일하다.
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println(scores[1][1]);
		
		//2*3 배열을 선언하고
		//1에서 10까지 무작위 수를 입력 하세요 
		//같은 수 입력 가능 
		int [][] arr = new int [2][3];
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				int rnnum = (int)(Math.random()*10)+1;
				arr[i][j] = rnnum;	
				System.out.printf("%2d \t",arr[i][j]);
			}
			System.out.println();
		}
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		//향상된 for 문 + 다차원 배열
		for (int[] row : arr) {
			for (int j : row) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		//향상된 for 문
		int [] su = {10,200,30,40,-50,777,55};
		//배열의 합, 최댓값, 최솟값 을 구하세요
		//향상된 for 문을 이용
		int sum = 0;
		int max = Integer.MIN_VALUE; //int 값 중 최솟값 
		int min = Integer.MAX_VALUE; //int 값 중 최댓값
		for(int ele : su){
			sum += ele;
			if (max < ele) {
				max = ele;
			}
			if (min > ele) {
				min = ele;
			}
		}
		System.out.println("sum = " + sum );
		System.out.printf("최댓값=%d 최솟값=%d",max,min );
		

	}

}
