package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Chatter {
	private boolean startSending = true;
	private BufferedReader input;
	private PrintWriter output;
	private BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	private PrintWriter console = new PrintWriter(new OutputStreamWriter(System.out));
	
	public Chatter(InputStream is, OutputStream os) {
		input = new BufferedReader(new InputStreamReader(is));
		output = new PrintWriter(new OutputStreamWriter(os));
	}

	public Chatter(InputStream is, OutputStream os, boolean startSending) {
		this(is, os);
		this.startSending = startSending;
	}
	
	public void go() throws IOException {
		boolean finished = false;
		while (!finished) {
			if (startSending) {
				console.print("> ");
				console.flush();
				output.println(keyboard.readLine() + '\n');
				output.flush();
			} else {
				startSending = true;
			}
			console.println("- " + input.readLine());
		}
	}
}
