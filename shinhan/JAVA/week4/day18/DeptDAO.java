package com.shinhan.day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.day18.DeptDTO;
import com.shinhan.util.DBUtil;

public class DeptDAO {


	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptList = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DeptDTO emp = makeDept(rs);
				deptList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}

	private DeptDTO makeDept(ResultSet rs2) throws SQLException {
		DeptDTO dept = new DeptDTO();
		dept.setDepartment_id(rs.getInt("department_id"));
		dept.setDepartment_name(rs.getString("department_name"));
		dept.setLocation_id(rs.getInt("manager_id"));
		dept.setManager_id(rs.getInt("location_id"));
		
		return dept;
	}
	
	public DeptDTO selectByID(int deptid) {
		String sql = "select * from departments where department_id = ?";
		DeptDTO dept = null;
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			rs = pst.executeQuery();
			if (rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
}
