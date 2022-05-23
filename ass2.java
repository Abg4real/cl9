package assignment2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {

			@SuppressWarnings("resource")
			Socket s = new Socket("127.0.0.1", 3001);
			DataInput dis = new DataInputStream(s.getInputStream());
			String msg = dis.readUTF();
			System.out.println(msg);
		} catch (Exception e) {
		}
	}
}


package assignment2;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(3001);
			Socket s = server.accept();
			System.out.println("Connected To Server for Message Passing from DYPCOE...");
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(" Hi Lakhan ...Welcome	to socket");
		} catch (Exception e) {
		}
	}
}
