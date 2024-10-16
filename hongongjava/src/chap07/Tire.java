package chap07;

public class Tire {
	//필드
	public int maxRotation;
	public int accRotation;
	public String location;
	
	//생성자
	//타이어의 위치, 타이어의 수명을 외부 값 받아서 초기화 
	public Tire (String location, int maxRotation) {
		this.location = location;
		this.maxRotation=maxRotation;
	}
	
	//메소드
	//타이어 수명 체크 메소드 
	public boolean roll() {
		++accRotation;
		if (accRotation<maxRotation) {
			System.out.println(location + "Trie 수명:" + (maxRotation - accRotation) + "회");
			return true;
		}else {
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
}
