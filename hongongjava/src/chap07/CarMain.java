package chap07;

public class CarMain {

	public static void main(String[] args) {
		//객체 형성 
		
		Car car = new Car();
		
		//자동차 5번 운행 
		for (int i=1; i<=5; i++) {
			//car() 실행 해준다. = run() 실행 한다. 
			int problemLocation = car.run();
			
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire 교체");
				car.frontLeftTire = new HankookTire ("앞왼쪽",15);
				break;
			
			case 2:
				System.out.println("앞오른쪽 KumhoTire 교체");
				car.frontRightTire = new KumhoTire ("앞오른쪽",13);
				break;
			
			case 3:
				System.out.println("뒤왼쪽 HankookTire 교체");
				car.backLeftTire = new HankookTire ("뒤왼쪽",14);
				break;
			
			case 4:
				System.out.println("뒤오른쪽 KumhoTire 교체");
				car.backRightTire = new KumhoTire ("뒤오른쪽",17);
				break;
				
			}
			System.out.println("----------------------------------");
		}

	}

}
