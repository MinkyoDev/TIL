package com.shinhan.myapp.emp;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	// type이 같으면 자동으로 injection
	@Autowired
	EmpDAOInserface empDAO;

	public EmpDTO loginCheck(String email, String phone) {
		return empDAO.loginCheck(email, phone);
	}

	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	public EmpDTO selectByID(int empID) {
		return empDAO.selectById(empID);
	}

	public List<EmpDTO> selectByDepartmentID(int departmentID) {
		return empDAO.selectByDeptId(departmentID);
	}

	public List<EmpDTO> selectByJob(String jobID) {
		return empDAO.selectByJobId(jobID);
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}
}
