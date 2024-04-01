package com.shinhan.day11.c15_5_StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		queue();
	}

	public static void queue() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		queue.offer(200);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	public static void stack(String[] args) {
		// LIFO
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(500);
		stack.push(300);
		stack.push(400);
		stack.push(200);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
