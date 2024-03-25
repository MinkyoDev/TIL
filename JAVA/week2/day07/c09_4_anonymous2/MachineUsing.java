package com.shinhan.day07.c09_4_anonymous2;

public class MachineUsing {

	// field
	Machine v1 = new Machine() {

		@Override
		public void powerOn(String title) {
			System.out.println("익명구현 class 만든다. field");
		}
	};

	public static void main(String[] args) {

		// 구현 class
		Machine v3 = new MachineImpl();
		call(v3);

		// local variable
		Machine v2 = new Machine() {

			@Override
			public void powerOn(String title) {
				System.out.println("익명구현 class 만든다. local variable");
			}
		};
		call(v2);

		// parameter
		call(new Machine() {

			@Override
			public void powerOn(String title) {
				System.out.println("익명구현 class 만든다. parameter");
			}
		});

		call((s) -> System.out.println(s + " lamda"));
	}

	private static void call(Machine machine) {
		machine.powerOn("*****");
	}
}
