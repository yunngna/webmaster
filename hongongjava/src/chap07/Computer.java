package chap07;

public class Computer extends Calculator {
	//필드
	//생성자
	//메소드
	// 메소드 재 정의
	
	//ctrl + space 넣으면 부모(상위) 클래스에 요소 들이 다 나온다. 
	
	@Override
	double areaCircle(double r) {
		return Math.PI * r * r;
	}// 안에 리턴 값은 변화 할 수 있다.
	
	//super은 자식 클래스 생성 에서만 사용 가능 하다. 
	double ac(double r) {
		if (r >= 10) {
			double rs = super.areaCircle(r); // 부모 것 사용 
			return rs;
		}else {
			double rs = areaCircle(r); // 자식 것 사용 
			return rs;
		}
	}
}
