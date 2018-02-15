package com.senla.bookshop.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.bookshop.menu.MenuController;
import com.senla.bookshop.server.MultiThread;

public class NewClient {
	
	private static final Logger logger = Logger.getLogger(NewClient.class);
	private final static int PORT = 8991;

	public static void main(String[] args) {
		try {

			Socket clientSocket = new Socket(InetAddress.getLocalHost(), PORT);
			MultiThread serverWorker = new MultiThread(clientSocket);
			MenuController menuController = new MenuController(serverWorker);
			menuController.run();

		} catch (IOException e) {
			logger.error("Connection problems!", e);
		}
	}

}
