package com.shinhan.myapp.job;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.dept.DeptDAOMybatis;

@Repository
public class JobDAOMybatis {
	
	@Autowired
	SqlSession sqlSession;
	
	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String nameSpace = "com.shinhan.myapp.emp.";
	
	public List<JobDTO> selectAll() {
		logger.info("JobDAOMybatis...selectAll");
		return sqlSession.selectList(nameSpace+"selectAllJob");
	}
}
