package chap06;

public class Computer {
	//필드
	//생성자
	//메서드
	int sum1(int[] values) {
		int sum = 0;
		for(int i=0; i<values.length;i++) {
			sum += values[i];
		}
		return sum;
	}
	
	int sum2(int ... values) {
		int sum = 0;
		for (int num : values) { //향상된 for 문 = values에 저장된 값을 num 에 하나하나 저장해서 넣어주는 것
			sum += num;
		}
		return sum;
	}

}
