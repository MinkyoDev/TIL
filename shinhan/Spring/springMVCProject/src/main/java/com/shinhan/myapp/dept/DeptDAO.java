package com.shinhan.myapp.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository
public class DeptDAO implements DeptDAOInserface{
	
	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	
		public int deptDelete(int deptid) {
			int result = 0;
			String sql = "delete from departments"
					+ " where DEPARTMENT_ID=?";
			try {
				conn = ds.getConnection();
				pst = conn.prepareStatement(sql);
				pst.setInt(1, deptid);
				result = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}
		
	
	//7. 수정(Update)
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		String sql = "update departments"
				+ " set DEPARTMENT_NAME=?,"
				+ " MANAGER_ID=?,"
				+ " LOCATION_ID=?,"
				+ " where DEPARTMENT_ID=?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dept.getDepartment_name());
			pst.setInt(2, dept.getManager_id());
			pst.setInt(3, dept.getLocation_id());
			pst.setInt(4, dept.getDepartment_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//6. 입력(Insert)
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		String sql = "insert into departments values(?,?,?,?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//5. 다양한 조건으로 조회하기
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * "
				+ " from departments "
				+ " where DEPARTMENT_ID= ?"
				+ " and DEPARTMENT_NAME = ?"
				+ " and MANAGER_ID = ?"
				+ " and LOCATION_ID = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, deptname);
			pst.setInt(3, mid);
			pst.setInt(4, lid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return deptlist;
	}
	
	
	//2. 특정부서의 상세보기
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		String sql = "select * from departments where department_id = " + deptid;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
	//1. 부서모두조회
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return deptlist;
	}
	
	
	//특정직원 1명 조회
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();
		dept.setDepartment_id(rs.getInt("department_id"));
		dept.setDepartment_name(rs.getString("department_name"));
		dept.setLocation_id(rs.getInt("location_id"));
		dept.setManager_id(rs.getInt("manager_id"));

		return dept;
	}


	@Override
	public DeptDTO selectByName(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}
}
