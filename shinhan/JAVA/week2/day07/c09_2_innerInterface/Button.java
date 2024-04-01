package com.shinhan.day07.c09_2_innerInterface;

public class Button {

	public static interface ClickListener {
		void onClick(); // 추상 메서드

	}

	// field
	ClickListener listener;

	// setter
	void setListener(ClickListener listener) {
		this.listener = listener;
	}

	void click() {
		listener.onClick();
	}
}
