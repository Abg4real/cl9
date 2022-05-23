// adder
package assignment1b;

import java.rmi.*;
public interface Adder extends Remote{

public int add(int x,int y)throws RemoteException;
}

// adder remote

package assignment1b;

import java.rmi.*;
import java.rmi.server.*;

@SuppressWarnings("serial")
public class AdderRemote extends UnicastRemoteObject implements Adder {
	/**
	 * 
	 */

	AdderRemote() throws RemoteException {
		super();
	}

	public int add(int x, int y) {
		return x + y;
	}

}

// client
package assignment1b;

import java.rmi.*;
import java.util.*;

public class Client {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ENTER THE FIRST NUMBER");
		int a = sc.nextInt();
		System.out.println("ENTER THE SECOND NUMBER");
		int b = sc.nextInt();
		try {

			Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/lakhan");
			System.out.println("SUM OF THE NUMBERS ARE: " + stub.add(a, b));

		} catch (Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}


// server

package assignment1b;

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
	public static void main(String args[]) throws RemoteException {
//		System.setProperty("java.rmi.server.hostname","localhost:5000/lakhan");

		Registry rgsty = LocateRegistry.createRegistry(5000);
		try {

			Adder stub = new AdderRemote();
			Naming.rebind("rmi://localhost:5000/lakhan", stub);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
