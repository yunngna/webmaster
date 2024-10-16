package chap03;

public class Assign146 {

	public static void main(String[] args) {
		int result = 0;
		result += 10; 
		System.out.println(result);
		result -= 5;
		System.out.println(result);
		result *=3;
		System.out.println(result);
		result /= 5;
		System.out.println(result);
		result %= 3;
		System.out.println(result);
		
		//2진수 계산 [case1) 1 => 01  2 => 10 으로 & 적용 시 00 이 나온다. 00은 0을 의미한다. 
		//          case2) 2 = 10  2 = 10 으로 & 적용하면 10 이 나온다. 그래서 2를 의미한다.
		//          case3) 1= 01 2= 10  으로 | 적용시 11 이 나온다. 11은 3을 의미 (2^1 + 2^0) 
		//          case4) ^의 경우 같으면 0 다르면 1을 나타낸다.  ]
		int su = 1;
		int su2 = 2;
		System.out.println(su & su2);
		System.out.println(su | su2);
		System.out.println(su ^ su2);
		
	
	}

}
