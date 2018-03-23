package com.senla.bookshop.utils.annotations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.annotations.CsvEntity;

public class AnnotationCSVReader {

	public static List<?> readerFromCsv(Class<?> entityClass)
			throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ParseException {
		List<Object> objects = new ArrayList<>();
		String[] array;
		CsvEntity annotation = entityClass.getAnnotation(CsvEntity.class);
		try (BufferedReader bf = new BufferedReader(new FileReader(annotation.fileName()))) {
			List<String> lines = new ArrayList<String>();
			String csvline = null;
			while ((csvline = bf.readLine()) != null) {
				lines.add(csvline);
			}
			array = lines.toArray(new String[0]);
		}
		for (String lineForCut : array) {
			String[] cutLine = lineForCut.trim().split(annotation.valuesSeparator());
			objects.add(AnnotationCSVParser.parseToObject(entityClass, cutLine));
		}
		return objects;
	}

}
