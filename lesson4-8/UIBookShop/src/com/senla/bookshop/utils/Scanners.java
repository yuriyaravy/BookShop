package com.senla.bookshop.utils;

import java.util.Scanner;

public class Scanners {
	
	public static int scannerForInteger(){
		int scanResualt = 0;
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			scanResualt = sc.nextInt();
		}else{
			System.out.println("You can write only numbers");
		}
		return scanResualt;
	}
	
	public static String scannerForString(){
		String scanResualt = null;
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			scanResualt = sc.nextLine();
		}else{
			System.out.println("You can write only text");
		}
		return scanResualt;
	}

}
