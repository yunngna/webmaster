package chap13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Time586 {

	public static void main(String[] args) {
		// 프로그램 실행 시간 체크
		
		List <String> list1 = new ArrayList<String>();
		List <String> list2 = new LinkedList<String>();
		
		// 시작, 마지막 시간 객체 
		long startTime;
		long endTime;
		
		//ArrayList 10000개의 객체 추가 경우 시간 체크
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list1.add(0,String.valueOf(i));
		}
		endTime=System.nanoTime();
		System.out.println("ArrayList 걸린 시간:" + (endTime - startTime) + "ns");
		
		//LinkedList 10000개의 객체 추가 경우 시간 체크 
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list2.add(0,String.valueOf(i));
		}
		endTime=System.nanoTime();
		System.out.println("LinkedList 걸린 시간:" + (endTime - startTime) + "ns");	
	}

}
