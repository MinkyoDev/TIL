package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;


// Controller -> Service -> DAO
// Service : 비지니스 로직을 수행한다.
public class EmpService {

	EmpDAO empDAO = new EmpDAO();

	public EmpDTO loginCheck(String email, String phone) {
		return empDAO.loginCheck(email, phone);
	}
	// 1. 직원 모두 조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2. 특정 직원 1명 조회 - 상세보기
	public EmpDTO selectByID(int empID) {
		return empDAO.selectByID(empID);
	}
	
	// 3. 특정 부서의 직원들 조회
	public List<EmpDTO> selectByDepartmentID(int departmentID) {
		return empDAO.selectByDepartmentID(departmentID);
	}
	
	// 4. 특정 job인 직원조회
	public List<EmpDTO> selectByJob(String jobID) {
		return empDAO.selectByJob(jobID);
	}
	
	// 5. 다양한 조건으로 조회하기
	// 부서별(=), 직책별(=), 입사일별(>=), 급여(>=)	
	public List<EmpDTO> selectByCondition(int deptid, String jibid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jibid, hdate, salary);
	}
	
	// 6. 입력
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	// 7. 수정
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	// 8. 삭제
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 9. 직원 번호를 이용해서 직원의 이름과 직책과 급여를 조회한다.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	
	// 10. 직원번호가 들어오면 직원 보너스를 return하는 함수를 호출한다.
		public double callFunction(int empid) {
			return empDAO.callFunction(empid);
		}
}
