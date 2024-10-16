package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		//new 로 저장 하기 때문에 주소가 다 다르다.
		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		set.add(new Member("권길동",35));
		set.add(new Member("김길동",30));
		
		System.out.println("총 객체수 :" + set.size());
		
		//전체 set 출력 
		//iterator 사용 
		Iterator<Member>iterator = set.iterator(); // iterator 은 iterator 타입의 값을 저장 한다.  (값이 있는지 없는지 체크 하는 반복자)
		while (iterator.hasNext()) { // 안에 값이 있으면 true 없으면 false ( false가 되면 중지)
			Member element = iterator.next();
			System.out.printf("이름 : %s  나이 : %d \n",element.name ,element.age);
		}
		System.out.println();
		
		//향상된 for문 사용 
		for (Member mb : set) {
			System.out.printf("이름 : %s 나이 : %d \n",mb.name ,mb.age);
		}
		

	}

}
