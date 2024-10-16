package 도서관리; 


import java.util.List;
import java.util.Scanner;

public class bookMain {

	static Scanner snc = new Scanner(System.in); // main 클래스 밖에서 사용시 static으로 해줘야 한다. 
	static MemberDao mdao = MemberDao.getInstance(); // MemberDao getInstance() 메소드로 MemberDao 클래스 접근 
	
	public static void main(String[] args) {
		// 도서관리

		Member member = null;
		
		//아이디 비밀번호 맞는지 체크
		while(true) {
			System.out.print("아이디 입력>>");
			String id = snc.nextLine();
			System.out.print("비밀번호 입력>>");
			String pw = snc.nextLine();
			
			//정상적으로 아이디 비밀번호 맞는지 확인 (1)
//			if (mdao.checkMember(id, pw)) {
//				break;			 // checkMember()메소드가 true 이면 break	
//			}
			
			// 정상적으로 로그인 되면 "이름" 환영합니다 출력  (2) 
//			String name = mdao.checkMember(id,pw);
//			if (name != null) {
//				System.out.println(name + "환영합니다");
//				break;
//			}
//			System.out.println("아이디와비밀번호를 확인하세요!");

		
			//아이디비번체크 -> 맞으면 "이름" 환영합니다 출력 -> 권환 (responsibility) 체크 해서 user  -> 도서관리 처리  admin -> 회원관리 처리  (3) 
			member = mdao.checkMember(id,pw);
			if (member != null) {
				System.out.println(member.getMemberName() + "환영합니다");
				break;
			}
			System.out.println("아이디와비밀번호를 확인하세요!");
			
		}//end of while_id,pw check 
		
		//권한이 user => 도서관리 처리  ,  권한이 admin => 회원관리 처리
		if(member.getReponsibility().equals("User")) {
			bookManage();
		}else if(member.getReponsibility().equals("Admin")) {
			memberManage();
		}
		
		
					
	}//end main 
	
	// responsibility 의 user = 도서관리  admin = 회원관리 으로 구분 하기  
	
	//도서관리 
	static void bookManage() {
//		BookDao dao = null;
		BookDao dao = new BookDao();
		boolean run = true;
		int cnt = 0;
		while (run) {
			//메인메뉴
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("1.도서등록  2.도서검색  3.도서 전체 조회  4.도서 삭제  5.도서 정보 변경  6.프로그램 종료");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.print("메뉴입력>");
			int menunum = Integer.parseInt(snc.nextLine());
			switch (menunum) {
			case 1 :
				//선택1번 : 도서 등록
				System.out.println("[도서등록]");
				System.out.print("책제목>");
				String title = snc.nextLine();
				System.out.print("저자>");
				String writer = snc.nextLine();
				System.out.print("가격>");
				int price = Integer.parseInt(snc.nextLine());
				System.out.print("책번호>");
				String bnum = snc.nextLine();
				
				Book book = new Book(title,writer,price,bnum);
				
				cnt = dao.insert(book);
				if (cnt ==1 ) {
					System.out.println("추가성공");
				}else {
					System.out.println("추가 실패");
				}
				
				break;
			case 2 :
				//선택 2번 : 도서 검색  => 책 제목으로 검색
				System.out.println("[도서검색]");
				System.out.print("책제목>");
				title = snc.nextLine();
			
				Book result = dao.select(title);
				System.out.println(result);
				break;
			case 3 :
				// 선택 3번 : 도서 전체 조회 
				System.out.println("[도서 전체 조회]");
				
				dao.selectAll();
				break;
			case 4:
				// 선택 4번 : 도서 삭제 
				System.out.println("[도서검색]");
				System.out.print("책 번호>");
				bnum = snc.nextLine();
				
				cnt = dao.remove(bnum);
				if (cnt ==1 ) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				
				break;
			case 5:
				// 선택 5번 : 도서 정보 변경
//	           책제목 : 변경할 책 번호, 변경할 책 가격 입력  => 수정
				System.out.println("[도서 정보 변경]");
				System.out.print("변경할 책 제목 입력>");
				title = snc.nextLine();
				System.out.println("변경내용| 책 번호>");
				bnum = snc.nextLine();
				System.out.println("변경내용 | 책 가격>");
				price = Integer.parseInt(snc.nextLine());
				
				cnt = dao.update(title, price, bnum);
				if (cnt ==1 ) {
					System.out.println("정보 변경 성공");
				}else {
					System.out.println("정보 변경 실패");
				}
				
				break;
			
			case 6:
				//선택 6번 : 프로그램 종료 
				run = false;
				snc.close();		
				System.out.println("프로그램을 종료합니다.");	
				break;		
			}
		}	
	} // close bookManage()
	
	//회원관리
	static void memberManage() {
		
		boolean run = true;
		int cnt = 0;
		while (run) {
			//메인메뉴
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("1.회원등록  2.회원검색  3.회원 전체 조회  4.회원 삭제  5.회원 정보 변경  6.프로그램 종료");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.print("메뉴입력>");
			int menunum = Integer.parseInt(snc.nextLine());
			switch (menunum) {
			//1. 회원등록
			case 1 :
				System.out.println("[회원등록]");
				System.out.print("아이디>");
				String id = snc.nextLine();
				System.out.print("비밀번호>");
				String pw = snc.nextLine();
				System.out.print("이름>");
				String name = snc.nextLine();
				System.out.print("연락처>");
				String phone = snc.nextLine();
				Member member = new Member(id,pw,name,phone);
				cnt = mdao.insert(member);
				if (cnt ==1 ) {
					System.out.println("추가성공");
				}else {
					System.out.println("추가실패");
				}
				break;
				
			//2. 회원 조회 (아이디 입력)
			case 2:
				System.out.println("[회원조회]");
				System.out.print("아이디>");
				id = snc.nextLine();
				
				Member result = mdao.select(id);
				System.out.println(result);
				break;
				
			//3. 회원 전체 조회 
			case 3:
//				//선택 3번 : 회원 목록 출력
				System.out.println("[회원 전체 조회]");
				List<Member> list = mdao.memberList(); // memberlist() 메소드가 반환 값이 List<Member>로 타입을 맞춰줘야 한다. 
				System.out.println("----------------------------------------------------");
				System.out.println("                    회원 목록");
				System.out.println("----------------------------------------------------");
				
				for (Member mb : list) {
					mb.print();
//					System.out.println(mb.toString()); // overide 된 Tostring 사용
				}
				break;
			//4. 회원 삭제 (아이디 입력)
			case 4:
				System.out.println("[회원조회]");
				System.out.print("아이디>");
				id = snc.nextLine();
				cnt = mdao.delete(id);
				if (cnt ==1 ) {
					System.out.println("삭제성공");
				}else {
					System.out.println("삭제실패");
				}
				break;
			//5. 회원 정보 변경 (아이디 입력)
			case 5:
				System.out.println("[회원 정보 변경]");
				System.out.print("변경원하는 회원의 id>>");
				id = snc.nextLine();
				System.out.print("변경내용| 비밀번호>");
				pw = snc.nextLine();
				System.out.print("변경내용| 이름>");
				name = snc.nextLine();
				System.out.print("변경내용 | phone>");
				phone = snc.nextLine();
				System.out.print("변경내용 | responsibility>");
				String responsibility = snc.nextLine();
				
				cnt = mdao.update(id,pw,name,phone,responsibility);
				if (cnt ==1 ) {
					System.out.println("정보 변경 성공");
				}else {
					System.out.println("정보 변경 실패");
				}	
				
				break;
			case 6:
				run = false;
				snc.close();		
				System.out.println("프로그램을 종료합니다.");	
				break;	
			} //close switch
		}//close while
				
			
	}//close memberManage()

}//end class
