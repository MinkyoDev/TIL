package com.shinhan.day06.lab4;

class Activity {
	public void onCreate() {
		System.out.println("기본적인 실행 내용");
	}
}

class MainActivity extends Activity {
	@Override
	public void onCreate() {
		super.onCreate();  // 답: super
		System.out.println("추가적인 실행 내용");
	}
}

public class Prob11 {

	public static void main(String[] args) {
		MainActivity act = new MainActivity();
		act.onCreate();
	}
}
