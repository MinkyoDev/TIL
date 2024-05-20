package com.shinhan.myapp.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	// type이 같으면 자동으로 injection
	@Autowired
	EmpDAO empDAO;

	public EmpDTO loginCheck(String email, String phone) {
		return empDAO.loginCheck(email, phone);
	}
	// 1. 吏곸썝 紐⑤몢 議고쉶
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2. �듅�젙 吏곸썝 1紐� 議고쉶 - �긽�꽭蹂닿린
	public EmpDTO selectByID(int empID) {
		return empDAO.selectByID(empID);
	}
	
	// 3. �듅�젙 遺��꽌�쓽 吏곸썝�뱾 議고쉶
	public List<EmpDTO> selectByDepartmentID(int departmentID) {
		return empDAO.selectByDepartmentID(departmentID);
	}
	
	// 4. �듅�젙 job�씤 吏곸썝議고쉶
	public List<EmpDTO> selectByJob(String jobID) {
		return empDAO.selectByJob(jobID);
	}
	
	// 5. �떎�뼇�븳 議곌굔�쑝濡� 議고쉶�븯湲�
	// 遺��꽌蹂�(=), 吏곸콉蹂�(=), �엯�궗�씪蹂�(>=), 湲됱뿬(>=)	
	public List<EmpDTO> selectByCondition(int deptid, String jibid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jibid, hdate, salary);
	}
	
	// 6. �엯�젰
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	// 7. �닔�젙
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	// 8. �궘�젣
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 9. 吏곸썝 踰덊샇瑜� �씠�슜�빐�꽌 吏곸썝�쓽 �씠由꾧낵 吏곸콉怨� 湲됱뿬瑜� 議고쉶�븳�떎.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	
	// 10. 吏곸썝踰덊샇媛� �뱾�뼱�삤硫� 吏곸썝 蹂대꼫�뒪瑜� return�븯�뒗 �븿�닔瑜� �샇異쒗븳�떎.
		public double callFunction(int empid) {
			return empDAO.callFunction(empid);
		}
}
