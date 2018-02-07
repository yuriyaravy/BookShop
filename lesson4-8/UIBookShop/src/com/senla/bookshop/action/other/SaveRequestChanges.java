package com.senla.bookshop.action.other;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.storage.RequestStorage;
import com.senla.bookshop.utils.txtwork.TextSerializ;

public class SaveRequestChanges implements IAction{

	@Override
	public void execute() {
		Facade.getInstance().serializationForRequest();
	}

}
