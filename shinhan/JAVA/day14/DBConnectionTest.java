package com.shinhan.day14;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. jdbc driver를 class path에 추가
		// jdbc driver를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Oracle driver load success");
		
		// 2. DB 연결
		String url, userid="hr", password="hr";
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("Connect Database success");
		
		String sql = "select first_name||' '||last_name as 이름, salary 급여, department_id 부서id\r\n"
				+ "from employees\r\n"
				+ "where salary >= 15000";
		
		// 3. Statement : java와 db의 대화통로
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {  // data가 없을 때 까지
			String fname = rs.getString(1);
			int salary = rs.getInt(2);
			int deptid = rs.getInt(3);
			System.out.printf("%-10s\t%d\t%d\n", fname, salary, deptid);
		}
		rs.close();
		st.close();
		conn.close();
	}
}
