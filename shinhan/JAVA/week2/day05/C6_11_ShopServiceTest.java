package com.shinhan.week1.day05;

public class C6_11_ShopServiceTest {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		if (obj1 == obj2) {
			System.out.println("같은 ShopService");
		} else {
			System.out.println("다른 ShopService");
		}
	}
}
