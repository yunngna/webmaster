package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		// List 컬렉션
		// ArrayList
		List<String> list = new ArrayList<String>(); // import ctrl+shift + o

		// 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");

		// 검색
		// 사이즈
		int size = list.size();
		System.out.println("총 객체의 수:" + size);
		System.out.println();

		// 가져오기
		String skill = list.get(2);
		System.out.println("2:" + skill);
		System.out.println();

		// for 문 전체 내용 가져오기
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();

		// 향상된 for 문 전체 내용 가져오기
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println();

		// 삭제
		list.remove(2); // 인덱스로 삭제
		list.remove(2);
		list.remove("iBATIS");

		// for 문 전체 내용 가져오기
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();

		// 향상된 for 문 전체 내용 가져오기
		for (String str : list) {
			System.out.println(str);
		}

	}//end main

}//end class
