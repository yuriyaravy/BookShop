package com.senla.bookshop.utils.csvwork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.utils.setting.Setting;

public class ReadFromCSV {
	
	private static final Logger logger = Logger.getLogger(ReadFromCSV.class);
	static String[] array;
	
	public static String[] readCSV(String key){
		try(Scanner sc = new Scanner(new File(Setting.getPath(key)))){
			List<String>lines = new ArrayList<String>();
			while(sc.hasNextLine()){
				lines.add(sc.nextLine().replaceAll("\"", ""));
			}
			array = lines.toArray(new String[0]);
		}catch(IOException e){
			logger.error(e);
		}
		return array;
	}

}
