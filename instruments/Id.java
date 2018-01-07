package by.home.book.instruments;

public class Id {
	
	public static int creationId(){
		int newId = (int) (Math.random() * 1000);
		return newId;
	}

}
