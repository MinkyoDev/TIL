package com.shinhan.day13.c19_2_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {

	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException {
		System.out.println("------------------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하시오");
		System.out.println("-----------------------------");

		startServer();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		stopServer();
	}

	private static void startServer() {
		Thread thread = new Thread() {
			public void run() {
				try {
					serverSocket = new ServerSocket(5001);
					System.out.println("[서버] 시작됨");

					while (true) {
						System.out.println("[서버] 연결요청을 기다림");

						Socket socket = serverSocket.accept();

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 수락함");

						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();

						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터 다시보냄 " + message);
						
						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	private static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
		}
	}

}
