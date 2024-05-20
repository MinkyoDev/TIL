package com.shinhan.myapp.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository
public class EmpDAO {
	
	// 1. field 이용하기
	@Autowired
	DataSource ds;
	
	// 2. 생성자 이용하기
	//@Autowired
//	public EmpDAO(DataSource ds) {
//		this.ds = ds;
//	}
	
	// 3. 생성자 이용하기
//	@Autowired
//	public void setDs(DataSource ds) {
//		this.ds = ds;
//	}

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public EmpDTO loginCheck(String email, String phone) {
		String sql = "select employee_id, first_name, last_name, email, phone_number from employees where email = ?";
		EmpDTO emp = null;
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
//					emp = makeEmp(rs);
				if (rs.getString("phone_number").equals(phone)) {
					emp = new EmpDTO();
					emp.setEmployee_id(rs.getInt("employee_id"));
					emp.setFirst_name(rs.getString("first_name"));
					emp.setLast_name(rs.getString("last_name"));
					emp.setEmail(email);
				} else {
					emp = new EmpDTO();
					emp.setEmployee_id(-2);
				}
			} else {
				emp = new EmpDTO();
				emp.setEmployee_id(-1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emp;
	}

	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));

		return emp;
	}

	public EmpDTO selectByID(int empID) {
		String sql = "select * from employees where employee_id = ?";
		EmpDTO emp = null;
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empID);
			rs = pst.executeQuery();
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emp;
	}

	public List<EmpDTO> selectByDepartmentID(int departmentID) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = String.format("select * from employees where department_id = %d", departmentID);
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 4. �듅�젙 job�씤 吏곸썝議고쉶
	public List<EmpDTO> selectByJob(String jobID) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = upper(?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, jobID); // 泥ル쾲夷� ?�뿉 jobID瑜� �꽔�쓬
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return emplist;
	}

	public List<EmpDTO> selectByCondition(int deptid, String jibid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select *" + " from employees" + " where department_id = ?" + " and job_id = ?"
				+ " and hire_date >= ?" + " and salary >= ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, jibid);
			pst.setDate(3, hdate);
			pst.setInt(4, salary);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return emplist;
	}

	// 6. �엯�젰
	public int empInsert(EmpDTO emp) {
		int result = 0;
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 7. �닔�젙
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		String sql = "update employees set ? = ? where EMPLOYEE_ID = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			if (emp.getFirst_name() != null) {
				pst.setString(1, "First_name");
				pst.setString(2, emp.getFirst_name());
			}
			if (emp.getLast_name() != null) {
				pst.setString(1, "Last_name");
				pst.setString(2, emp.getLast_name());
			}
			if (emp.getEmail() != null) {
				pst.setString(1, "Email");
				pst.setString(2, emp.getEmail());
			}
			if (emp.getPhone_number() != null) {
				pst.setString(1, "Phone_number");
				pst.setString(2, emp.getPhone_number());
			}
			if (emp.getHire_date() != null) {
				pst.setString(1, "Hire_date");
				pst.setDate(2, emp.getHire_date());
			}
			if (emp.getJob_id() != null) {
				pst.setString(1, "Job_id");
				pst.setString(2, emp.getJob_id());
			}
			if (emp.getSalary() != 0) {
				pst.setString(1, "Salary");
				pst.setInt(2, emp.getSalary());
			}
			if (emp.getCommission_pct() != 0) {
				pst.setString(1, "Commission_pct");
				pst.setDouble(2, emp.getCommission_pct());
			}
			if (emp.getManager_id() != 0) {
				pst.setString(1, "Manager_id");
				pst.setInt(2, emp.getManager_id());
			}
			if (emp.getDepartment_id() != 0) {
				pst.setString(1, "Department_id");
				pst.setInt(2, emp.getDepartment_id());
			}
			pst.setInt(3, emp.getEmployee_id());

			result = pst.executeUpdate(); // DML�� executeUpdate, Select�뒗 executeQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 8. �궘�젣
	public int empDelete(int empid) {
		int result = 0;
		String sql = "delete from employees where employee_id = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	public Map<String, Object> empInfo(int empid) {
		Map<String, Object> empMap = new HashMap<>();

		String fname = null;
		String job = null;
		int salary = 0;

		String sql = "{call sp_empInfo(?, ?, ?, ?)}";
		CallableStatement cstmt = null;
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.execute();
			fname = cstmt.getNString(2);
			job = cstmt.getNString(3);
			salary = cstmt.getInt(4);
			empMap.put("fname", fname);
			empMap.put("job", job);
			empMap.put("salary", salary);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		return empMap;
	}

	public double callFunction(int empid) {
		double bonus = 0;
		String sql = "select f_bonus(?) from dual";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if (rs.next()) {
				bonus = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bonus;
	}
}
