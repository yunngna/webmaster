package chap10;

public class ExceptionMain {

	public static void main(String[] args) {
		//예외처리 
		try {
			Class clazz = Class.forName("java.lang.String");
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
//			e.printStackTrace(); //오류 원인 출력문장
			System.out.println("class를 찾지 못했어요");
		}
		
		try {
			String strNum = "a123";
			int num = Integer.parseInt(strNum);
			System.out.println(num);
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("변경 불가");
		}
		

	}

}
