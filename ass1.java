package Assignment1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) throws UnknownHostException, IOException {
		int number, temp;
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("127.0.0.1", 1342);
		Scanner sc1 = new Scanner(s.getInputStream());
		System.out.println("Enter any number");
		number = sc.nextInt();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(number);
		temp = sc1.nextInt();
		System.out.println(temp);
		sc.close();
		s.close();
	}
}


// server

package Assignment1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String args[]) throws IOException {
		int number, temp;
		ServerSocket s1 = new ServerSocket(1342);
		Socket ss = s1.accept();
		Scanner sc = new Scanner(ss.getInputStream());
		number = sc.nextInt();
		temp = number * 2;
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(temp);
		s1.close();
	}
}
