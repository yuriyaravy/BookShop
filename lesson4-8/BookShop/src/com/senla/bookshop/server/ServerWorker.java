package com.senla.bookshop.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;


public class ServerWorker {
	
	final static Logger logger = Logger.getLogger(ServerWorker.class);
	
	private static ServerWorker severWorker;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private ServerWorker(){
		
	}
	
	public static ServerWorker getInstance(){
		if(severWorker == null){
			severWorker = new ServerWorker();
		}
		return severWorker;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException | NullPointerException e) {
			logger.error(e);
		}
	}
	
	public Response sendMessage(Request message) {
		try {
			output.writeObject(message);
			output.flush();
			return (Response) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			logger.error(e);
			return null;
		}
	}
	
	public void end(){
		try {
			socket.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}

}
