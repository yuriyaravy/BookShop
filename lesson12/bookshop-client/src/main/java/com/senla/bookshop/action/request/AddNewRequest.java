package com.senla.bookshop.action.request;

import java.sql.SQLException;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class AddNewRequest implements IAction{

	@Override
	public void execute() {
		try {
			Printers.show(Facade.getInstance().getBooks());
		} catch (Exception e1) {
			Printers.show("Could not show books");
		}
		Printers.show("what book do you want request");
			try {
				Facade.getInstance().addRequest(Scanners.scannerForInteger());
			} catch (SQLException e) {
				Printers.show("You did not add request");
			}
	}

}
