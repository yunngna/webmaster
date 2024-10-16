package chap06;

public class StudentMain {

	public static void main(String[] args) {
		//(2) 객체 실행 클래스 
		// 객체 생성해서 클래스 사용  
		// 1. 객체 생성
//		Student st1 = new Student("240901","홍길동");
//		System.out.println(st1.stNo);
//		System.out.println(st1.name);
//		st1.study();
//		
//		Student st2 = new Student("240902", "강아지");
//		System.out.println(st2.stNo);
//		System.out.println(st2.name);
//		st2.study(); //study = 메서드 이름 , (): 실행 
		
		
//		Student stu1 = new Student("240901","홍길동",50,60,70);
//		Student stu2 = new Student("224951","강아지",52,67,89);
//		Student stu3 = new Student("260601","고양이",23,56,45);
//		Student stu4 = new Student("270751","주리",89,75,70);
//		Student stu5 = new Student("250501","미니",98,89,76);
		
		Student[] students = {
				new Student("240901","홍길동",50,60,70),
				new Student("224951","강아지",52,67,89),
				new Student("260601","고양이",23,56,45),
				new Student("270751","권주리",89,75,70),
				new Student("250501","손미니",98,89,76),
		};
		
		for (Student student : students) {
			System.out.printf("%s | %s | %d | %d | %d | %d | %.2f | %s \n",student.stNo,student.name,student.korean,student.english,student.math,student.sum(),student.avg(),student.grade());
		}

	}

}
