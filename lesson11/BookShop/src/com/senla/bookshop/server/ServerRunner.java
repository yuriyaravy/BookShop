package com.senla.bookshop.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.di.DependencyIngection;

public class ServerRunner {
	
	private static final int PORT = 8991;
	
	private static Logger logger = LogManager.getLogger(ServerRunner.class);

	public static void main(String[] args) {
		
		IFacade facade = (IFacade) DependencyIngection.getInctance().getClassInstance(IFacade.class);
		
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				Socket socket = server.accept();
				MultiThread serverTread = new MultiThread(socket);
				serverTread.start();
			}
			
		}catch(IOException e){
			logger.error(e);
		}

	}

}
