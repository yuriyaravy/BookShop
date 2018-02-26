package com.senla.bookshop.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ServerWorker {
	
	final static Logger logger = Logger.getLogger(ServerWorker.class);
	
	private Socket socket;
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private void save() {
		Request request = new Request("exit", null);
		sendRequest(request);
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			System.out.println("From Server worker " + socket);
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException | NullPointerException e) {
			logger.error("Errors with ServerWorker!", e);
		}
	}
	
	public Object sendRequest(Request message) {
		Object response = null;
		try {
			output.writeObject(message);
			output.flush();
			response = input.readObject();
			return response;
		} catch (IOException | ClassNotFoundException e) {
			logger.error(e);
			return null;
		}
	}
	
	public void disconnect(){
		try {
			save();
			output.close();
			input.close();
			socket.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}

}