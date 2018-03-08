package com.senla.bookshop.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.bookshop.server.MultiThread;

public class ServerTest {
	
	private static final int PORT = 8991;
	
	private static Logger logger = LogManager.getLogger(ServerTest.class);

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				Socket socket = server.accept();
				MultiThread serverTread = new MultiThread(socket);
				System.out.println("Server name " + serverTread.getName());
				serverTread.start();
			}
			
		}catch(IOException e){
			logger.error(e);
		}	
	}

}
