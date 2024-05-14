package com.shinhan.myapp.section01;

public class TVFactory {

	public static TV makeTV(String brand) {
		TV tv = null;

		if (brand.equals("samsung")) {
			tv = new SamsungTV("ddd123");
		} else if (brand.equals("lg")) {
			tv = new LgTV();
		} else {
			
		}
		
		return tv;
	}
}
