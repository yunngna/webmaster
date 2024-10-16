package chap07;

public class HttpServletExample {
	
	public static void method (HttpServlet servlet) {
		servlet.Service();
	}
	
	
	// 메인 메소드 실행 
	public static void main(String[] args) {
		method (new LoginServlet());
		method (new FiledownloadServlet());

	}

}
