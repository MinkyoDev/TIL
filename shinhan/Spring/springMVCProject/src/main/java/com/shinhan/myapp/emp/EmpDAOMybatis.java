package com.shinhan.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.dept.DeptDAOMybatis;

@Repository
public class EmpDAOMybatis implements EmpDAOInserface {

	@Autowired
	SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String nameSpace = "com.shinhan.myapp.emp.";

	@Override
	public EmpDTO loginCheck(String email, String phone) {
		logger.info("EmpDAOMybatis...loginCheck");
		return sqlSession.selectOne(nameSpace + "loginCheck", email);
	}

	@Override
	public List<EmpDTO> selectAll() {
		logger.info("EmpDAOMybatis...selectAll");
		return sqlSession.selectList(nameSpace + "selectAll");
	}

	@Override
	public EmpDTO selectById(int empId) {
		 logger.info("EmpDAOMybatis...selectByID");
		 return sqlSession.selectOne(nameSpace + "selectById", empId);
	}

	@Override
	public List<EmpDTO> selectByDeptId(int departmentId) {
		logger.info("EmpDAOMybatis...selectByDeptId");
		return sqlSession.selectList(nameSpace + "selectByDeptId", departmentId);
	}

	@Override
	public List<EmpDTO> selectByJobId(String jobId) {
		logger.info("EmpDAOMybatis...selectByJobId");
		return sqlSession.selectList(nameSpace + "selectByJobId", jobId);
	}
	
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("deptid", deptid);
		conditionMap.put("jobid", jobid);
		conditionMap.put("hdate", hdate);
		conditionMap.put("salary", salary);
		List<EmpDTO> emplist = sqlSession.selectList(nameSpace + "selectByCondition", conditionMap);
		logger.info(emplist.size() + "건 조회됨");
		return emplist;
	}

	@Override
	public int empInsert(EmpDTO emp) {
		logger.info("EmpDAOMybatis...empInsert");
		return sqlSession.insert(nameSpace + "empInsert", emp);
	}

	@Override
	public int empUpdate(EmpDTO emp) {
		logger.info("EmpDAOMybatis...empUpdate");
		return sqlSession.update(nameSpace + "empUpdate", emp);
	}

	@Override
	public int empDelete(int empid) {
		logger.info("EmpDAOMybatis...empDelete");
		return sqlSession.delete(nameSpace + "empDelete", empid);
	}

}
