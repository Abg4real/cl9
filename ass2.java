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
