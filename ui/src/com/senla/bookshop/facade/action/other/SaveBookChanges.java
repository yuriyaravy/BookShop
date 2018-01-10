package ui.src.com.senla.bookshop.facade.action.other;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class SaveBookChanges implements IAction{

	@Override
	public void execute() {
		Facade.getInstance().serializationForBook();
	}

}
