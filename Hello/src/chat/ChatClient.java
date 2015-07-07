package chat;

import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) throws Throwable {
		Socket s = new Socket("localhost", 9999);
		new Chatter(s.getInputStream(), s.getOutputStream()).go();
	}
}
