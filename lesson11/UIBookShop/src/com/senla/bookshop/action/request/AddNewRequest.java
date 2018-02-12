package com.senla.bookshop.action.request;

import java.sql.SQLException;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class AddNewRequest implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getBooks());
		System.out.println("what book do you want request");
			try {
				Facade.getInstance().addRequest(Scanners.scannerForInteger());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
