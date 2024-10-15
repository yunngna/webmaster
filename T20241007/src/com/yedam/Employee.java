package com.yedam;



public class Employee {
	//필드
	private String employeeNum;
	private String employeeName;
	private String phone;
	private String hireD;
	private String salary;
	//생성자
	Employee(){}
	
	Employee(String employeeNum, String employeeName, String phone){
		this.employeeNum = employeeNum;
		this.employeeName = employeeName;
		this.phone = phone;
	}
	
	Employee(String employeeNum, String employeeName, String phone, String hireD, String salary){
		this.employeeNum = employeeNum;
		this.employeeName = employeeName;
		this.phone = phone;
		this.hireD = hireD;
		this.salary = salary;
	}
	//메소드

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	


	public String getHireD() {
		return hireD;
	}

	public void setHireD(String hireD) {
		this.hireD = hireD;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return employeeNum +"\t"+ employeeName+"\t" + phone;
	}
	
	

}
