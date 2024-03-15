package com.shinhan.day04;

public class C6_6_NoteBookTest {

	public static void main(String[] args) {
		NoteBook note1 = new NoteBook("A", 100);
		NoteBook note2 = new NoteBook("B", 200);
		NoteBook note3 = new NoteBook("C", 300);
		
//		System.out.println(note1.count);
//		System.out.println(note2.count);  // int count -> 내가 원하는건 이게 아님
//		System.out.println(note3.count);  // 바람직한 접근이 아님
		
		System.out.println(NoteBook.count);
	}
}
