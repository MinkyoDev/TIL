package com.shinhan.day05;

public class ShopService {
	private static ShopService shop;
	
	// 생성자의 접근지정자를 private
	private ShopService() {
		
	}
	
	public static ShopService getInstance() {
		if (shop==null) {
			shop = new ShopService();
		}
		return shop;
	}
}
