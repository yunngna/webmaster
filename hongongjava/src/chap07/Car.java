package chap07;

public class Car {
	//필드
	//Tire class 를 타입으로 필드(초기값) 주고 지정한다. 
	Tire frontLeftTire = new Tire("앞왼쪽",6);
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽",3);
	Tire backRightTire = new Tire("뒤오른쪽",4);
	
	//생성자
	//메소드 
	//Tire의 roll()메소드(타이어 수명 체크 메소드)를 적용하는데, false = 바퀴가 펑크 나면 해당 location 위치 번호를 return 한다.
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll()==false) {stop(); return 1; }
		if(frontRightTire.roll()==false) {stop(); return 2; }
		if(backLeftTire.roll()==false) {stop(); return 3; }
		if(backRightTire.roll()==false) {stop(); return 4; }
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
