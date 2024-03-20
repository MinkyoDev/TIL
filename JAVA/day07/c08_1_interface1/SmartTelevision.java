package com.shinhan.day07.c08_1_interface1;

public class SmartTelevision implements RemoteController, Searchable {

	@Override
	public void search(String url) {
		System.out.println(url + "SmartTelevision search");

	}

	@Override
	public void method1() {
		System.out.println("SmartTelevision method1");
	}

	@Override
	public void method2() {
		System.out.println("SmartTelevision method2");
	}

	@Override
	public void turnOn() {
		System.out.println("SmartTelevision turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTelevision turnOff");
	}

}
