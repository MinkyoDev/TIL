package com.shinhan.myapp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
	
	@Autowired
	DeptDAO deptDAO;

	//8. ����(Delete)
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);

	}

	// 7. ����(Update)
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	// 6. �Է�(Insert)
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}

	// 5. �پ��� �������� ��ȸ�ϱ�
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
		return deptDAO.selectByCondition(deptid, deptname, mid, lid);
	}
	// 2. Ư���μ��� �󼼺���
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}

	// 1. ���������ȸ
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
}
