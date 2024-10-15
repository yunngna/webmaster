package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
	// 1. 연결설정 메소드(void)
	Connection conn = null;
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@192.168.0.33:1521:xe",
						"java",
						"1234");
				System.out.println("연결 성공");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//2. 연결 종료 메소드(void)
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("연결 끊기");
		}
	}
	
	//3. 등록
	int insert (Employee employee) {
		getOpen();
		try {
			String sql = ""
					+ "insert into employee (employee_num,employee_name,phone,hire_date,salary) "
					+ "values ( ?, ?, ?, TO_DATE(?), ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmployeeNum());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setString(3, employee.getPhone());
			pstmt.setString(4, employee.getHireD());
			pstmt.setString(5, employee.getSalary());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
//			e.printStackTrace();
			return 0;
		}
		
		
	}
	//4. 목록 select 전체 조회 (사번, 이름, 전화번호)
	void selectAll () {
		getOpen();
		try {
			String sql = "select employee_num , employee_name,  phone " 
					+ "from employee ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Employee>list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(new Employee (rs.getString("employee_num"), rs.getString("employee_name"),rs.getString("phone")));		
			}
			for (Employee ep : list) {
				System.out.println("사번      이름       전화번호");
				System.out.println(ep.toString());
			}
			getClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//5. 수정 update
	int update (String employeeNum , String salary) {
		getOpen();
		try {
			String sql = "" + 
					"update employee " +
					"set salary = ? " +
					"where employee_num =? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, salary);
			pstmt.setString(2, employeeNum);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
		
		
	}
	//6. 삭제 delete
	int delete (String employeeNum) {
		getOpen();
		try {
			String sql = "delete from employee " +
						"where employee_num =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeNum);
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
	}
	//7. 조회 (입사일자 받고 날짜 이후 모두 나오기)
	List <Employee> select(String hireD) {
		List<Employee> result = new ArrayList<>();
		getOpen();
		try {
			String sql = "select employee_num , employee_name,  hire_date "
					+"from employee "
					+"where hire_date >= To_DATE(?,'YYYY-MM-DD') ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hireD);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee ep = new Employee();
				ep.setEmployeeNum(rs.getString("employee_num"));
				ep.setEmployeeName(rs.getString("employee_name"));
				ep.setPhone(rs.getString("hire_date"));
				result.add(ep);	
			}
			getClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return result;
		
			
		}
	}//close class
	

