package com.senla.bookshop.action.other;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;

public class SaveBookChanges implements IAction{

	@Override
	public void execute() {
		Facade.getInstance().serializationForBook();
	}

}
