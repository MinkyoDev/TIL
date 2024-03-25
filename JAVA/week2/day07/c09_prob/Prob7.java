package com.shinhan.day07.c09_prob;

class Chatting {
	class Chat {
		void start() {}

		void sendMesage(String message) {}
	}

	void startChat(String chatId) {
		String nickName = null;
//		nickName = chatId;

		// 내부 class에서 지역변수를 참조하는 경우 final - nickname 변경 불가
		Chat chat = new Chat() {

			@Override
			public void start() {
				while (true) {
					String inputDate = "안녕하세요";
					String message = "[" + nickName + "]" + inputDate;
					sendMesage(message);
				}
			}
		};

		chat.start();
	}
}

public class Prob7 {

	public static void main(String[] args) {
		Chatting chat = new Chatting();
		chat.startChat("1");
	}
}
