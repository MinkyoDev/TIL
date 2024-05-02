package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.job.JobDTO;
import com.shinhan.job.JobService;


@WebServlet("/job/jobList.do")
public class JobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobService jobService = new JobService();
		List<JobDTO> joblist = jobService.selectAll();
		System.out.println(joblist);

		request.setAttribute("joblist", joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("jobList.jsp");
		rd.forward(request, response);
	}
}
