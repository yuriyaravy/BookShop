package com.senla.bookshop.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.facade.Facade;

public class MultiThread extends Thread{
	
	final static Logger logger = Logger.getLogger(MultiThread.class);
	private IFacade facade = (IFacade) DependencyIngection.getInctance().getClassInstance(IFacade.class);
	private ObjectOutputStream outputstm;
	private ObjectInputStream inputstm;
	
	public MultiThread(Socket socket){
		try {
			outputstm = new ObjectOutputStream(socket.getOutputStream());
			inputstm = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			logger.error(e);
		}
	}
	
	private Response execute(Request message){
		Response response = null;
		Class<?>[] parameterTypes = new Class[message.getParameters().length];
		
		for(int i =0; i < parameterTypes.length; i++){
			parameterTypes[i] = message.getParameters()[i].getClass();
		}
		try {
			Method method = Facade.class.getMethod(message.getMethodName(), parameterTypes);
			response = new Response(method.invoke(facade, message.getParameters()));
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	
	}
	
	private void end(){
		facade.serializationForBook();
		facade.serializationForOrder();
		facade.serializationForRequest();
		try{
			outputstm.close();
			inputstm.close();
		}catch(IOException e){
			logger.error(e);
		}finally {
			this.interrupt();
		}
	}


	@Override
	public void run() {
		try {
			Request message;
			while (true) {
				message = (Request) inputstm.readObject();
				if (message != null) {
					Response response = execute(message);
					outputstm.writeObject(response);
					outputstm.flush();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.error(e);
		} finally {
			end();
		}
	}

}
