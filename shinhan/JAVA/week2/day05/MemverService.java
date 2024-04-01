package com.shinhan.week1.day05;

public class MemverService {

	boolean login(String id, String passward) {
		if (id.equals("admin") && passward.equals("1234")) {
			return true;
		}
		return false;
	}

	void logout(String id) {
		System.out.println(id + "Bye~");
	}
}
