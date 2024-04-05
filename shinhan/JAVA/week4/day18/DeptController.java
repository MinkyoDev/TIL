package com.shinhan.day18;

import java.util.List;
import java.util.Scanner;

public class DeptController {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		
		while (!isStop) {
			int job = menuDisplay();
			
			switch (job) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든부서조회");
			}
			case 2 -> {
				System.out.print("부서번호> ");
				int dept = sc.nextInt();
				DeptView.print(deptService.selectByID(dept), "특정부서조회");
			}
			default ->{}
			}
		}
		System.out.println("============END============");
	}
	
	private static int menuDisplay() {
		System.out.println("=======================================================");
		System.out.println("1.모든부서조회  2.특정부서조회");
		System.out.println("0.종료");
		System.out.println("=======================================================");
		System.out.print("선택> ");
		int job = sc.nextInt();
		return job;
	}
}
