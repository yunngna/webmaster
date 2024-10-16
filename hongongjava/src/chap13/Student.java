package chap13;

public class Student {
	// 필드
	public int studentNum;
	public String name;

	// 생성자
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	// 메소드
	@Override
	public int hashCode() {
		return name.hashCode() + studentNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student)obj;
			return student.name.equals(name)&&(student.studentNum == studentNum);
		}else {
			return false;
		}
	}
}


