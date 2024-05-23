package com.shinhan.myapp.dept;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("deptmybatis")
public class DeptDAOMybatis implements DeptDAOInserface {

	@Autowired
	SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String nameSpace = "com.shinhan.myapp.dept.";

	@Override
	public List<DeptDTO> selectAll() {
		logger.info("DeptDAOMybatis...selectAll");
		return sqlSession.selectList(nameSpace + "selectAll");
	}

	@Override
	public DeptDTO selectById(int deptId) {
		logger.info("DeptDAOMybatis...selectById");
		return sqlSession.selectOne(nameSpace + "selectById", deptId);
	}

	@Override
	public DeptDTO selectByName(String deptName) {
		logger.info("DeptDAOMybatis...selectByName");
		return sqlSession.selectOne(nameSpace + "selectByName", deptName);
	}

	@Override
	public int deptInsert(DeptDTO dept) {
		logger.info("DeptDAOMybatis...deptInsert");
		return sqlSession.insert(nameSpace + "deptInsert", dept);
	}

	@Override
	public int deptUpdate(DeptDTO dept) {
		logger.info("DeptDAOMybatis...deptUpdate");
		return sqlSession.update(nameSpace + "deptUpdate", dept);
	}

	@Override
	public int deptDelete(int deptId) {
		logger.info("DeptDAOMybatis...deptDelete");
		return sqlSession.delete(nameSpace + "deptDelete", deptId);
	}

}
