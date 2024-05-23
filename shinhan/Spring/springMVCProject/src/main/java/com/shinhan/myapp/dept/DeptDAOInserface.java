package com.shinhan.myapp.dept;

import java.util.List;

public interface DeptDAOInserface {

	public List<DeptDTO> selectAll();

	public DeptDTO selectById(int deptId);
	
	public DeptDTO selectByName(String deptName);

	public int deptInsert(DeptDTO dept);

	public int deptUpdate(DeptDTO dept);

	public int deptDelete(int deptId);

}
