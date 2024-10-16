package chap07;

public class HankookTire extends Tire {

	// 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	// 메소드
	//Tire의 자식으로 수명을 바꿔주는데 사용 
	@Override
	public boolean roll() {
		++accRotation;
		if (accRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명:" + (maxRotation - accRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + " HankookTire 펑크 ***");
			return false;
		}
	}

}
