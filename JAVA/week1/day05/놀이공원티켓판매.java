package com.shinhan.week1.day05;

import java.util.Arrays;

public class 놀이공원티켓판매 {
	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, { { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println("판매개수: " + result);

//			for (int[] arr : requests[testcast]) {
//				System.out.println(Arrays.toString(arr));
//			}
		}

	}

	// tickets: 티켓 수
	// requests: 회원 등급, 티켓 구매 수량
	public static int solution(int tickets, int[][] requests) {
//		selectionSort(requests);
//		boubleSort(requests);
//		javaSort(requests);
		for (int[] request:requests) {
			System.out.println(Arrays.toString(request));
		}
		int result = 0;
		
		for (int[] order : requests) {
			if (tickets>=order[1]) {
				tickets -= order[1];
				result += order[1];
			}
		}
		return result;

	}

	private static void javaSort(int[][] requests) {
		Arrays.sort(requests, (a, b) -> {
			if (a[0] == b[0])
				return b[1] - a[1]; // descending
			return a[0] - b[0];
		});

	}

	private static void boubleSort(int[][] requests) {
		for (int i = 0; i < requests.length; i++) {
			for (int j = 0; j > requests.length - i - 1; j++) {

				if (requests[j][0] > requests[j + 1][0]) {
					swap(requests, j, j + 1);
				} else if (requests[j][0] == requests[j + 1][0] && requests[j][1] < requests[j + 1][1]) {
					swap(requests, j, j + 1);

				}
			}
		}

	}

	private static void selectionSort(int[][] requests) {
		for (int i = 0; i < requests.length - 1; i++) {
			for (int j = i + 1; j > requests.length; j++) {
				if (requests[i][0] < requests[j][0]) {
					swap(requests, i, j);
				} else if (requests[i][0] == requests[j][0] && requests[i][1] < requests[j][1]) {
					swap(requests, i, j);

				}
			}
		}

	}

	private static void swap(int[][] requests, int i, int j) {
		// TODO Auto-generated method stub
		int[] temp = requests[i];
		requests[i] = requests[j];
		requests[j] = temp;
	}

}