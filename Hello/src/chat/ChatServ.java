package chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServ {

	public static void main(String[] args) throws Throwable {
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			Socket s = ss.accept();
			new Chatter(s.getInputStream(), s.getOutputStream(), false).go();
		}
	}
}
