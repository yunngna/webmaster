package chap06;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		// 메뉴 1. 도서 수 입력, 2. 도서 입력 (for문) 3. 도서 목록 조회 (배열) 4. 도서 분석 5. 종료  [scanner]
		// 도서 수 만큼 배열 생성 -> 도서 객체 저장
		// 메뉴 항목 선택 1 => 도서 수 입력
		//             2 => 도서 객체 생성 배열에 저장
		//             3 => 도서 목록 출력
		//             4 => 도서 평균 가격, 최대 가격 출력
		//             5 => 종료 
		
		
		
		boolean run = true;
		Library[] booklist = null; // 배열 변수 초기화 , null의 의미는 배열이 연결 되지 않았다(배열의 주소를 할당 받지 못했다).
		//Library[] booklist; => 에러 발생하는데 이유가 배열 변수 초기화 전에 사용 해서 이다. 
		Scanner snc = new Scanner(System.in);
		
		while(run) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println( "1.도서 수 입력  2.도서 입력  3.도서 목록 조회  4.도서목록 분석  5.종료");
		System.out.println("-----------------------------------------------------------------");
		System.out.print("입력>");
		int num = Integer.parseInt(snc.nextLine());
		
			switch (num) {
			case 1 : 
				System.out.print("1. 도서수 입력>");
				int booknum = Integer.parseInt(snc.nextLine());
				booklist = new Library[booknum];
				break;
				
			case 2:
				for (int i =0; i < booklist.length; i++) {
					Library myLib = new Library(); // 객체하나에 데이터는 하나만 담기기 때문에 for문 돌때 마다 객체 역시 하나씩 생성해줘야 한다.
					System.out.print("책 제목 ["+ (i+1) + "] >" );
					String booknm = snc.nextLine();
					myLib.setBooknm(booknm);
		
					System.out.print("도서 번호 ["+ (i+1) + "] >" );
					String booknb = snc.nextLine();
					myLib.setBooknb(booknb);
					
					System.out.print("도서 가격 ["+ (i+1) + "] >" );
					int bookpc = Integer.parseInt(snc.nextLine());
					myLib.setBookpc(bookpc);
					
					booklist[i] = myLib;
					}
				break;
				
			case 3:
				for (Library book : booklist) {
					System.out.printf("책 제목 : %s | 도서 번호 : %s | 도서 가격 : %d \n" , book.getBooknm() , book.getBooknb() , book.getBookpc());		
				}
				break;
				
			case 4:
				int sum = 0;
				int avg = 0;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				String title = null;
				
				// sum 구하고 배열의 길이로 나누기 => avg
				for (int i = 0; i< booklist.length; i++) {
		
					int p = booklist[i].getBookpc();
					sum += p;
					if (max < p ) {
						max = p;
						title = booklist[i].getBooknm();
						
					}
					if(min > p) {
						min = p;
					}
				}
				avg = sum /booklist.length;
				System.out.printf("도서 평균 가격 = %d, 최대 가격 = %d, 최대 가격의 책 제목:%s , 최저 금액=%d",avg,max,title,min);
				System.out.println();
				break;
			case 5:
				run = false;
				break;
				
			}
		}System.out.println("프로그램을 종료합니다.");
		snc.close();
		
				

	}

}
