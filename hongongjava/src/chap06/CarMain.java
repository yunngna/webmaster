package chap06;

public class CarMain {

	public static void main(String[] args) {
		// 객체 생성 ( 객체란 클래스 생성 에서 생성자 제외하고 나머지를 모두 저장하고 있다) 
		Car myCar = new Car();
		
		//객체 사용
		//1. 필드값 읽기 
		System.out.println("제작회사:"+myCar.company);
		System.out.println("모델명:" + myCar.model);
		System.out.println("색상:" + myCar.color);
		System.out.println("최고속도:" + myCar.getMaxSpeed());
		System.out.println("현재속도:" + myCar.getSpeed());
		
		//2. 필드값 변경 
		myCar.setSpeed(60);
		System.out.println("수정된 속도:" + myCar.getSpeed());
		
		myCar.color = "흰색";
		System.out.println("수정된 색상:" + myCar.color);
		
		
		//교재P279
		System.out.println("--------------------------자동차 주행 P279 -----------------------------------");
		//가스 넣기 
		myCar.setGas(5); // 5
		//가스 체크 -> boolean true 경우 출발 및 주행 (가스가 다 떨어질때 까지)
		boolean gasState = myCar.isLeftGas(); //true
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();
		}
		//가스 체크 
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요");
		}
		
		//교재 p284
		System.out.println("---------------------------------교재 P284-----------------------------------");
		myCar.keyTurnOn();
		myCar.run2();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도:" + speed + "km/h");
		
		//교재 p327
		System.out.println("---------------------------------교재 P327-----------------------------------");
		myCar.setSpeed(-50);
		System.out.println("현재 속도" + myCar.getSpeed()); // 의미 없는 값이 안들어 오도록 해주는 것 
		
		myCar.setSpeed(60);
		System.out.println("현재 속도" + myCar.getSpeed());
		
		if (!myCar.isStop()) { // boolean stop의 기본 값이 false 이기 때문에 ! 붙여서 true 
			myCar.setStop(true);
		}
		System.out.println("현재 속도"+ myCar.getSpeed());

	}

}
