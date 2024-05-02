package com.shinhan.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class JobDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public List<JobDTO> selectAll() {
		List<JobDTO> joblist = new ArrayList<>();
		String sql = "select * from jobs";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				JobDTO job = makeJob(rs);
				joblist.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return joblist;
	}
	
	private JobDTO makeJob(ResultSet rs) throws SQLException {
		JobDTO job = new JobDTO();
		job.setJob_id(rs.getString("job_id"));
		job.setJob_title(rs.getString("job_title"));
		job.setMin_salary(rs.getInt("min_salary"));
		job.setMax_salary(rs.getInt("max_salary"));

		return job;
	}
}
