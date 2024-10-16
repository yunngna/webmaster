package 권나윤;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		boolean run = true;
		Account[] bank = new Account[100];

		Scanner snc = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("1.계좌생성  2.계좌목록  3.예금  4.출금  5.종료");
			System.out.println("-----------------------------------------------------------------");
			System.out.print("입력>");
			int menunum = Integer.parseInt(snc.nextLine());

			switch (menunum) {
			case 1:
				System.out.println("--------------");
				System.out.println(" 계좌생성 ");
				System.out.println("--------------");

				for (int i = 0; i < bank.length; i++) {
					if (bank[i] == null) {
						Account perim = new Account();
						System.out.print("계좌번호>");
						String accountnum = snc.nextLine();
						perim.setAno(accountnum);

						System.out.print("계좌주>");
						String name = snc.nextLine();
						perim.setOwner(name);

						System.out.print("초기입금액>");
						int firstmoney = Integer.parseInt(snc.nextLine());
						perim.setBalance(firstmoney);

						bank[i] = perim;
						System.out.println("계좌 개설 성공");
						break;
					}
				}
				break;
			case 2:
				System.out.println("--------------");
				System.out.println(" 계좌목록 ");
				System.out.println("--------------");
				for (Account list : bank) {
					if (list != null) {
						System.out.printf("계좌번호 %s | 계좌주 %s | 잔고 %d \n", list.getAno(), list.getOwner(),list.getBalance());
					}
				}
				break;
			case 3:
				System.out.println("--------------");
				System.out.println(" 예금 ");
				System.out.println("--------------");

				System.out.print("계좌번호>");
				String accountnum = snc.nextLine();
				System.out.print("예금액>");
				int deposit = Integer.parseInt(snc.nextLine());

				for (int i = 0; i < bank.length; i++) {
					if (bank[i] != null && bank[i].getAno().equals(accountnum)) {
						int newBalance = bank[i].getBalance() + deposit;
						bank[i].setBalance(newBalance);
						System.out.println("잔고는" + bank[i].getBalance());
						break;
					}
					if (bank[i] == null) {
						System.out.println("계좌번호를 다시 입력하세요");
						break;
					}
				}

				break;
			case 4:
				System.out.println("--------------");
				System.out.println(" 출금 ");
				System.out.println("--------------");

				System.out.print("계좌번호>");
				accountnum = snc.nextLine();
				System.out.print("출금액>");
				int withdraw = Integer.parseInt(snc.nextLine());

				for (int i = 0; i < bank.length; i++) {

					if (bank[i] != null && bank[i].getAno().equals(accountnum)) {
						int newBalance = bank[i].getBalance() - withdraw;
						bank[i].setBalance(newBalance);
						System.out.println("잔고는" + bank[i].getBalance());
						break;
					}
					if (bank[i] == null) {
						System.out.println("계좌번호를 다시 입력하세요");
						break;
					}
				}
				break;
			case 5:
				run = false;
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		snc.close();

	}//end main

}//end class
