package com.shinhan.day15;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.shinhan.day15.util.DateUtil;

// 사용자 요청 -> Controller -> Service
// 추후에 Servlet으로 작성할 예정
public class EmpController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		EmpService empService = new EmpService();

		while (!isStop) {
			int job = menuDisplay();
			switch (job) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<EmpDTO> emplist = empService.selectAll();
				EmpView.print(emplist, "모든직원조회");
			}
			case 2 -> {
				System.out.print("직원번호> ");
				int empid = sc.nextInt();
				EmpView.print(empService.selectByID(empid), "특정직원조회");
			}
			case 3 -> {
				System.out.print("부서번호> ");
				int depid = sc.nextInt();
				EmpView.print(empService.selectByDepartmentID(depid), "특정부서직원조회");
			}
			case 4 -> {
				System.out.print("Job이름> ");
				String jobID = sc.next();
				EmpView.print(empService.selectByJob(jobID), "특정Job직원조회");
			}
			case 5 -> {
				System.out.print("부서/직책/입사일0000-00-00/급여> ");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				Date hdate = DateUtil.getSQLDate(sc.next()); // 0000-00-00
				int sal = sc.nextInt();
				EmpView.print(empService.selectByCondition(deptid, jobid, hdate, sal), "조건조회");
			}
			case 6 -> {
				EmpDTO emp = insertMenu();
				int result = empService.empInsert(emp);
				EmpView.print(result > 0 ? "입력성공" : "입력실패");
			}
			case 7 -> {
				EmpDTO emp = insertMenu2();
				int result = empService.empUpdate(emp);
				EmpView.print(result > 0 ? "수정성공" : "수정실패");
			}
			case 8 -> {
				System.out.print("삭제할 직원번호> ");
				int empid = sc.nextInt();
				int result = empService.empDelete(empid);
				EmpView.print(result > 0 ? "입력성공" : "입력실패");
			}
			default -> {
			}
			}
		}
		System.out.println("============END============");
	}

	private static EmpDTO insertMenu2() {
		String tmp = "";
		sc.nextLine();
		
		System.out.print("EMPLOYEE_ID>>");
		tmp = sc.nextLine();
		int empid = tmp==""?0:Integer.parseInt(tmp);
		
		System.out.print("FIRST_NAME>>");
		tmp = sc.nextLine();
		String fname = tmp==""?null:tmp;
		
		System.out.print("LAST_NAME>>");
		tmp = sc.nextLine();
		String lname = tmp==""?null:tmp;
		
		System.out.print("EMAIL>>");
		tmp = sc.nextLine();
		String email = tmp==""?null:tmp;
		
		System.out.print("PHONE_NUMBER>>");
		tmp = sc.nextLine();
		String phone = tmp==""?null:tmp;
		
		System.out.print("HIRE_DATE>>");
		tmp = sc.nextLine();
		Date hdate = tmp==""?null:DateUtil.getSQLDate(tmp);
		
		System.out.print("JOB_ID>>");
		tmp = sc.nextLine();
		String job_id = tmp==""?null:tmp;
		
		System.out.print("SALARY>>");
		tmp = sc.nextLine();
		int sal = tmp==""?0:Integer.parseInt(tmp);
		
		System.out.print("COMMISSION_PCT>>");
		tmp = sc.nextLine();
		double comm = tmp==""?0:Double.parseDouble(tmp);
		
		System.out.print("MANAGER_ID>>");
		tmp = sc.nextLine();
		int mid = tmp==""?0:Integer.parseInt(tmp);
		
		System.out.print("DEPARTMENT_ID>>");
		tmp = sc.nextLine();
		int deptid = tmp==""?0:Integer.parseInt(tmp);

		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);

		return emp;
	}
	
	private static EmpDTO insertMenu() {
		System.out.print("EMPLOYEE_ID>>");
		int empid = sc.nextInt();
		System.out.print("FIRST_NAME>>");
		String fname = sc.next();
		System.out.print("LAST_NAME>>");
		String lname = sc.next();
		System.out.print("EMAIL>>");
		String email = sc.next();
		System.out.print("PHONE_NUMBER>>");
		String phone = sc.next();
		System.out.print("HIRE_DATE>>");
		Date hdate = DateUtil.getSQLDate(sc.next());
		System.out.print("JOB_ID>>");
		String job_id = sc.next();
		System.out.print("SALARY>>");
		int sal = sc.nextInt();
		System.out.print("COMMISSION_PCT>>");
		double comm = sc.nextDouble();
		System.out.print("MANAGER_ID>>");
		int mid = sc.nextInt();
		System.out.print("DEPARTMENT_ID>>");
		int deptid = sc.nextInt();
		
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);
		
		return emp;
	}

	private static int menuDisplay() {
		System.out.println("=======================================================");
		System.out.println("1.모든직원조회  2.특정직원조회  3.특정부서직원조회  4.특정Job직원조회");
		System.out.println("5.조건조회(부서/직책/입사일/급여)  6.입력  7.수정  8.삭제");
		System.out.println("0.종료");
		System.out.println("=======================================================");
		System.out.print("선택> ");
		int job = sc.nextInt();
		return job;
	}

}
