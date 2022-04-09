package org.diligentsnail.socketsseminar.echo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {
	// https://www.digi.com/resources/documentation/digidocs/90002258/tasks/t_echo_server.htm
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8888;

	public static void main(String[] args) throws IOException {
		try (Socket socket = new Socket(HOST, PORT);
			 InputStream inputStream = socket.getInputStream();
			 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
			bufferedWriter.write("abc");
			bufferedWriter.flush();
			int read;

			while ((read = inputStream.read()) != -1) {
				System.out.print((char) read);
			}

		}
	}
}
