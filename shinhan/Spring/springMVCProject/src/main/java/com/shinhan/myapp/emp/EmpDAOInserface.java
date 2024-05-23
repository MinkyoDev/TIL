package com.shinhan.myapp.emp;

import java.sql.Date;
import java.util.List;

public interface EmpDAOInserface {

	public EmpDTO loginCheck(String email, String phone);

	public List<EmpDTO> selectAll();

	public EmpDTO selectById(int empId);
	
	public List<EmpDTO> selectByDeptId(int departmentId);

	public List<EmpDTO> selectByJobId(String jobId);
	
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary);

	public int empInsert(EmpDTO emp);

	public int empUpdate(EmpDTO emp);

	public int empDelete(int empid);

}
