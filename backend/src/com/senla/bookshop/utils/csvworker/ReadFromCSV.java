package backend.src.com.senla.bookshop.utils.csvworker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ReadFromCSV {
	
	private static final Logger logger = Logger.getLogger(ReadFromCSV.class);
	
	public static ArrayList<String> readCSV(String path){
		ArrayList<String> lines = null;
		ArrayList<String> newLines = null;
		try(Scanner sc = new Scanner(new File(path))){
			lines = new ArrayList<String>();
			while(sc.hasNextLine()){
				lines.add(sc.nextLine().replaceAll("\"", ""));
			}
			String[] array = lines.toArray(new String[0]);
			String[] cutArray = array[1].split(", ");
			newLines = new ArrayList<>(Arrays.asList(cutArray));
		}catch(IOException e){
			logger.error(e);
		}
		return newLines;
	}

}
