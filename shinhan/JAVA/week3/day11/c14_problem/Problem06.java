package com.shinhan.day11.c14_problem;

class MovieThread extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("동영상을 재생합니다.");
//				if (this.isInterrupted()) break;  // sleep 말고 이렇게 써도 가능
				sleep(1);
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		System.out.println("자원 정리");
		System.out.println("안전종료");
	}
}

public class Problem06 {
	public static void main(String[] args) {
		Thread thread = new MovieThread();
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
	}

}