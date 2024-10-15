package com.yedam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EmpApp {

	public static void main(String[] args) {
		// main 
		Scanner snc = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		boolean run = true;
		int cnt=0;
		while(run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.print("메뉴입력>");
			int menunum = Integer.parseInt(snc.nextLine());
			
			switch(menunum) {
			case 1:
				//1. 등록
				System.out.print("사번입력>>");
				String employeeNum = snc.nextLine();
				System.out.print("이름입력>>");
				String employeeName = snc.nextLine();
				System.out.print("전화번호입력>>");
				String phone = snc.nextLine();
				System.out.print("입사일입력>>");
				String hireD = snc.nextLine();
				System.out.print("급여 입력>>");
				String salary = snc.nextLine();
				
				Employee employee = new Employee (employeeNum , employeeName, phone, hireD, salary);
				cnt = dao.insert(employee);
				if (cnt ==1 ) {
					System.out.println("추가성공");
				}else {
					System.out.println("추가 실패");
				}
				
				break;
			case 2:
				//2. 전체 조회
				dao.selectAll();
				break;
			case 3:
				//3. 수정 (사번 입력 받고 급여 수정)
				System.out.print("사번>>");
				employeeNum = snc.nextLine();
				System.out.print("급여>>");
				salary = snc.nextLine();
				
				cnt= dao.update(employeeNum, salary);
				if (cnt ==1 ) {
					System.out.println("정보 변경 성공");
				}else {
					System.out.println("정보 변경 실패");
				}
				
				
				break;
			case 4:
				//4. 삭제(사번 입력 받고 삭제)
				System.out.print("사번>>");
				employeeNum = snc.nextLine();
				cnt = dao.delete(employeeNum);
				if (cnt ==1 ) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				
				break;
			case 5:
				//5. 조회 (입사일자 입력 받고 입사일자 이후 모두 나오기)
				System.out.print("입사일자>>");
				hireD = snc.nextLine();
				List<Employee> list = new ArrayList<>();
				list = dao.select(hireD);
				for(Employee emp: list) {
					System.out.println(emp);
				}
			
				
				
				break;
			case 6:
				//6. 프로그램 종료
				run = false;
				snc.close();		
				System.out.println("프로그램을 종료합니다.");
				break;
			}//close switch 
		}//close while

	}//close main

}//close class
