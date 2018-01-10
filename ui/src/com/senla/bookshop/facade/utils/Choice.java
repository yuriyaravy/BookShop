package ui.src.com.senla.bookshop.facade.utils;

import java.util.Scanner;

public class Choice {
	
	public static int getInput(){
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter your choice: ");
		if(sc.hasNextInt()){
			choice = sc.nextInt();
		}else{
			System.out.println("it's not correct choice");
		}
		return choice;
	}

}
