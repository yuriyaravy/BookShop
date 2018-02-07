package com.senla.bookshop.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.bookshop.menu.MenuController;
import com.senla.bookshop.server.ServerWorker;
import com.senla.bookshop.utils.Printers;

public class Client {
	
	private final static Logger logger = Logger.getLogger(Client.class);

	private final static int PORT = 8991;
	
	private Socket socket;
	
	public Client(){
		try(Socket s = new Socket(InetAddress.getLocalHost(), PORT)){
			socket = s;
		} catch (IOException e) {
			logger.error(e);
			Printers.show("Connection  problem");
		}
	}
	
	public void run() throws ReflectiveOperationException {
		ServerWorker.getInstance().setSocket(socket);
		MenuController controller = new MenuController();
		controller.run();
	}
}
