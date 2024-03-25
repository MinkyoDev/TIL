package com.shinhan.day07.c09_2_innerInterface;

class Window {

	static interface Listener {
		void alert();
	}

	Listener listener;

	void setListener(Listener listener) {
		this.listener = listener;
	}

	void excute() {
		listener.alert();
	}
}

// 내부 interface를 구현한 class를 만들어야 함.
class MyListener1 implements Window.Listener {

	@Override
	public void alert() {
		System.out.println("구현 class에서 메서드를 재정의(1)");
	}

}

class MyListener2 implements Window.Listener {

	@Override
	public void alert() {
		System.out.println("구현 class에서 메서드를 재정의(2)");
	}

}

public class InnerInterfaceTest2 {

	public static void main(String[] args) {
		Window win = new Window();
		
		// 구현 class 이용 (비슷한 구현 class를 계속 만들어야하는 단점이 있다.)
		MyListener1 my1 = new MyListener1();
		win.setListener(my1);
		win.excute();
		
		// 익명 구현 class
		Window.Listener my2 = new Window.Listener() {
			
			@Override
			public void alert() {
				System.out.println("익명 구현 class");
			}
		};
		win.setListener(my2);
		win.excute();
		
		// lamda 표현식(메서드가 1개인 경우만 가능)
		win.setListener(()->System.out.println("lamda 표현식"));
		win.excute();
	}
}
