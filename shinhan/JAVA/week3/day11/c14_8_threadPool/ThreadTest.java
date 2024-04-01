package com.shinhan.day11.c14_8_threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			int idx = i;
			Future<Integer> result =  service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= idx; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread().getName() + " : " + idx + "까지의 합 => " + sum);
					return sum;
				}
			});
			try {
				Integer a = result.get();
				System.out.println(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
	}

	private static void f2() {
		String s = "Java";
		int score = 100;
		class LocalClass {
			void method1() {
//				s += "프로그램";
				System.out.println(s);
//				System.out.println(score);
			}
		}
		score += 100; // final이라 변경 불가능

		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println(s);
//				System.out.println(score);
			}
		};
	}

	public static void f1() {
		String[][] mails = new String[1000][3];

		int idx = 1;
		for (String[] arr : mails) {
			arr[0] = "admin@my.com";
			arr[1] = "memnber" + idx + "@my.com";
			arr[2] = "신상품 입고됨";
			idx++;
		}

		// multi thread(5)로 1000명의 email 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);

		// 내부 class에서 지역변수에 접근(지역변수는 final이다)
		for (int i = 0; i < 1000; i++) {
			int seq = i; // 값을 복사
			service.execute(new Runnable() {

				@Override
				public void run() {
					String message = "Thread name: " + Thread.currentThread().getName() + "\nfrom: " + mails[seq][0]
							+ "\nTo: " + mails[seq][1] + "\ncontent: " + mails[seq][2];
					System.out.println(message);
				}
			});
		}
	}
}
