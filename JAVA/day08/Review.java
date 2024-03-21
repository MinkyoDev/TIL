package com.shinhan.day08;

// 규격서
@FunctionalInterface  // lambda 표현식이 가능한지 check하는 annotation
interface JDBCInterface {
	// 1. 상수
	// 2. 추상 메서드 - 구현 class가 반드시 구현해야하는 의무가 있음.
	public abstract void connection();

	// 3. default method - 구현 가능, 구현 class가 공통적으로 사용하는 기능, 재정의 가능
	// 4. static method - 구현 가능, 재정의 불가능
	// 5. private method - default method에서만 호출 가능
}

// 구현 class
class OracleDB implements JDBCInterface {

	@Override
	public void connection() {
		System.out.println("Oracle DB connection");
	}

}

class MySQLDB implements JDBCInterface {

	@Override
	public void connection() {
		System.out.println("MySQL DB connection");
	}

}

public class Review {

	public static void main(String[] args) {
		work(new OracleDB());
		work(new MySQLDB());
		
		work(new JDBCInterface() {
			
			@Override
			public void connection() {
				System.out.println("anonymous class");
				method();
			}
			void method() {
				System.out.println("추가한 메서드는 JDBCInterface로는 호출 불가");
			}
		});
		
		work(()->System.out.println("use lambda fuction"));
		
	}

	private static void work(JDBCInterface db) {
		db.connection();
	}
}
