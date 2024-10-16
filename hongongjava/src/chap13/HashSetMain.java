package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		// set : 순서 보장 안됨, 중복 객체 저장 안됨, 반복자 필요함
		
		Set <String> set= new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체수:"+size);
		
		
		//전체 내용 가져오기 Iterator (추가 삭제 가능) 
		Iterator<String> iterator = set.iterator(); // 반복자 얻기 
		
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println();
		
		//향상된 for문으로 내용 가져오기 ( 읽기만 가능)
		for (String str : set) {
			System.out.println(str);
		}
		System.out.println();
		
		//삭제
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체의 수:" + set.size());// 사이즈 확인 메소드 실행을 해줘야 값 변경 됨 
		
//		iterator = set.iterator();
		for (String element:set) {
			System.out.println("\t" + element);
		}
		
		set.clear();
		if (set.isEmpty()) {System.out.println("비어 있음");}
		
	}

}
