package com.senla.bookshop.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class MultiThread extends Thread{
	
	final static Logger logger = Logger.getLogger(MultiThread.class);
	
	private Socket clientSocket;
	
	public MultiThread(Socket socket){
		this.clientSocket = socket;
	}
		
	@Override
	public void run() {
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(clientSocket.getOutputStream());
			input = new ObjectInputStream(clientSocket.getInputStream());
			while (true) {
				Request message  = (Request) input.readObject();
				if (message != null) {
					output.writeObject(Invoker.execute(message.getMethodName(), message.getParameters()));
					output.flush();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.error("Class or input/ouput errors",e);
		} finally {
			try{
			output.close();
			input.close();
			}catch(IOException e){
				logger.error("Failed to close!", e);
			}
		}
	}
	
	
}
