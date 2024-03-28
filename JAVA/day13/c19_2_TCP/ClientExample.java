package com.shinhan.day13.c19_2_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("192.168.0.39", 5001);
		System.out.println("[클라이언트] 연결 성공");
		
		String sendMessage = "난 자바가 좋은가...?";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(sendMessage);
		dos.flush();
		System.out.println("[클라이언트] 데이터 보냄 " + sendMessage);
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String receiveMessage = dis.readUTF();
		System.out.println("[클라이언트] 데이터 받음 " + receiveMessage);
		
		
		socket.close();
		System.out.println("[클라이언트] 연결 끊음");
	}
}
