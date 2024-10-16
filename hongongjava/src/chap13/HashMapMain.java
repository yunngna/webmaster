package chap13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		// Map : 키와 값으로 구성된 entry 저장 
		Map <String,Integer> map = new HashMap<String,Integer>();
		
		
		//객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		//map 크기
		System.out.println("map의 크기:" + map.size());
		
		//객체 찾기
		System.out.println("\t홍길동:" + map.get("홍길동"));
	
		
		//객체 하나씩 처리 (way1)
		System.out.println("--------------------전체 읽기 방법 1-------------------------------------");
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			String keys = keyIterator.next();
			Integer value = map.get(keys);
			System.out.println("\t" + keys + ":" + value);
		}
		System.out.println();
		
		System.out.println("--------------------전체 읽기 방법 1 향상된 for 문--------------------------");
		for (String key: keySet) {
			System.out.println(key + ":" + map.get(key));
		}
		System.out.println();
		
		
		//객체 삭제 
		map.remove("홍길동");
		System.out.println("총 Entry 수 :" + map.size());
		System.out.println();
		
		
		//객체 하나씩 처리  (way2) 
		System.out.println("--------------------전체 읽기 방법 2---------------------------------------");
		Set<Map.Entry<String, Integer>> entrySet =  map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + ":" + value);
		}
		System.out.println();
		
		System.out.println("--------------------전체 읽기 방법 2 향상된 for 문 --------------------------");
		
		//향상된 for 문 사용해서 하나씩 처리 
		for (Map.Entry<String, Integer> entry: entrySet) {
			System.out.println(entry.getKey()+ ":" + entry.getValue());
		}
		System.out.println();
		
		
		
		//객체 전체 삭제
		map.clear();
		
		System.out.println("총 Entry 수:" + map.size());

	}

}
