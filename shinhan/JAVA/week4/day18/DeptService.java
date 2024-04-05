package com.shinhan.day18;

import java.util.List;

public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();

	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
	
	public DeptDTO selectByID(int deptid) {
		return deptDAO.selectByID(deptid);
	}
}
