package com.senla.bookshop.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.bookshop.menu.MenuController;
import com.senla.bookshop.server.ServerWorker;

public class Client {
	
	private static final Logger logger = Logger.getLogger(Client.class);
	private final static int PORT = 8991;

	public static void main(String[] args) {
		try {

			Socket clientSocket = new Socket(InetAddress.getLocalHost(), PORT);
			ServerWorker.getInstance().setSocket(clientSocket);
			MenuController menuController = new MenuController();
			menuController.run();

		} catch (IOException e) {
			logger.error("Connection problems!", e);
		}
	}

}
