package chap08;

public class SoundableMain {
	
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	//출력하는 것이 메인에 있기 때문에 cat과 dog 에서 리턴을 받아주기만 하면 된다. 만약 메인에 출력이 없다면 cat, dog에 프린트 문 적어준다. 

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	
	}

}
