package chap06;

public class Car {
	//1. 필드생성
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	private int maxSpeed = 350;
	private int speed;
	private int gas;
	private boolean stop; // stop 값은 false 이다. 
	
	//2. 생성자생성 (반드시 있어야 한다 그러나 외부에서 받을 값이 없으면 컴파일러가 자동으로 만드는 기본 생성자 사용)
	//3. 메서드생성
	// Gas 입력
//	void SetGas(int gas) {
//		this.gas = gas;
//	} // 메서드를 통해 필드 초기화
	
	//스피드 가져오기
//	int getSpeed() { // 필드 값을 외부로 전달 (get) , 외부 값을 필드로 전달 (set)
//		return speed;
//	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
		this.speed = speed;
		}
	}
	
	public int getGas() {
		return gas;
	}
	
	public void setGas(int gas) {
		this.gas = gas;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	

	
	public boolean isStop() {
		return stop;
	} // true 인 경우 stop 

	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}

	//Gas확인
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	

	//car 달리기
	void run() {
		while(true) {
			if (gas > 0) {
				System.out.println("달립니다 gas 잔량: (" + gas + ")" );
				gas--;
			}else {
				System.out.println("멈춥니다.  gas 잔량: (" + gas + ")");
				return; // 가스 없으면 메서드 종료  (void 경우 return 넣으면 메서드 종료)
			}
		}
	}
	//시동 걸기
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	//스피드 체크 
	void run2() {
		for (int i=10; i<=50; i+=10) {
			speed = i;
			System.out.println("달립니다. (시속:" +speed +"km/h)");
		}
	}

}
