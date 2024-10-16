package chap06;

public class CalcMain {

	public static void main(String[] args) {
		// 메소드 오버로딩 p287
		
		//객체 만들기 
		Calculator myCalcu = new Calculator();
		
		//정사각형 넓기 구하기 
		double result1 = myCalcu.areaRectangle(10);
		
		//직사각형 넓이 구하기 
		double result2= myCalcu.areaRectangle(10,20);
		
		System.out.println("정사각형 넓이 :" + result1);
		System.out.println("직사각형 넓이 :" + result2);
		
	}

}
