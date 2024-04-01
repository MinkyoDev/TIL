package com.shinhan.day13.c19_1_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		f1();
	}
	
	private static void f1() {
		try {
			InetAddress a = InetAddress.getLocalHost();
			System.out.println(a.getHostName());
			System.out.println(a.getHostAddress());
			
			InetAddress[] arr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress add : arr) {
				System.out.println(add.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
