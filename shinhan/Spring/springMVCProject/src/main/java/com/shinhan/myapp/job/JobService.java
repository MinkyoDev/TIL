package com.shinhan.myapp.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	@Autowired
	JobDAOMybatis jobDAO;
	
	public List<JobDTO> selectAllJob() {
		return jobDAO.selectAll();
	}
}
