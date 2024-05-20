package com.shinhan.myapp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
	
	@Autowired
	DeptDAO deptDAO;

	//8. 삭제(Delete)
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);

	}

	// 7. 수정(Update)
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	// 6. 입력(Insert)
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}

	// 5. 다양한 조건으로 조회하기
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
		return deptDAO.selectByCondition(deptid, deptname, mid, lid);
	}
	// 2. 특정부서의 상세보기
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}

	// 1. 직원모두조회
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
}
