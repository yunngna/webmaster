package chap06;

public class Student {
	// (1) 객체를 만드는 클래스 만들기
	// 필드 (속성)
	String stNo;
	String name;
	int korean;
	int english;
	int math;

	// 생성자(객체를 생성) : 메소드는 기능(값을 받고 리턴값 있다)을 가지고 있으나 생성자는 객체를 만드는 역할만 한다. 그리고 클래스와 이름
	// 동일
	// -> 객체의 속성을 초기화 해준다. 객체가 동일한 값으로 초기화가 아니라 다 다른값을 가져야 할때 사용한다.
	Student(String stNo, String name, int korean, int english, int math) {
		this.stNo = stNo; // this = 객체
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	// 메소드 (기능)
	// 1. 결과 값이 없는 메소드 만들기
	void study() {
		System.out.println("공부합니다.");
	}

	// 2. 결과 값 있는 메소드
	// 총점
	int sum() {
		return  korean + english + math;
	}

	double avg() {
		return sum() / 3;
	}

	String grade() {
		String rank;
		int grades = (int)(avg() /10);
		switch(grades) {
			case 10:
				rank = "A등급";
			case 9:
				rank = "A등급";
				break;
			case 8 :
				rank = "B등급";
				break;
			case 7 :
				rank = "C등급";
				break;
			case 6:
				rank = "D등급";
				break;
			default:
				rank = "F등급";
				break;
		}
		return rank;
	}

}
