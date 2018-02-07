package com.senla.bookshop.utils.annotations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;

public class AnnotationCSVWriter {
	
	public static void wtiteToCSVFile(List<?> entities) throws NoSuchFieldException, IOException, IllegalArgumentException, IllegalAccessException {
		
		Map<Integer, String> sortedFields = new TreeMap<>();
		StringBuilder str = new StringBuilder();
		
		if(entities.size() != 0) {
			
			Class<?> entClass = entities.get(0).getClass();
			
			if(entClass.isAnnotationPresent(CsvEntity.class)){
				CsvEntity csvAnnotation = entClass.getAnnotation(CsvEntity.class);
				File file = new File(csvAnnotation.fileName());
				
				
				try(BufferedWriter buffereWriter = new BufferedWriter(new FileWriter(file))){
					if(!file.exists()){
						file.createNewFile();
					}
					for(int i = 0; i < entities.size(); i ++){
						Object element = entities.get(i);
						
							Field[] fields = element.getClass().getDeclaredFields();
							for(Field tempField : fields){
								if(tempField.isAnnotationPresent(CsvProperty.class))
									tempField.setAccessible(true);
								if(tempField.getAnnotation(CsvProperty.class).propertyType() == PropertyType.CompositeProperty){
									sortedFields.put(tempField.getAnnotation(CsvProperty.class).columnNumber(), AnnotationCSVParser.parseToString(tempField.get(element), tempField.getAnnotation(CsvProperty.class).keyField()));
								} else {
									sortedFields.put(tempField.getAnnotation(CsvProperty.class).columnNumber(), String.valueOf(tempField.get(element)));
								}
						}
						for (Map.Entry<Integer, String> field : sortedFields.entrySet()) {
							str.append(field.getValue()).append(csvAnnotation.valuesSeparator());
                        }
						buffereWriter.write(String.valueOf(str) + "\n");
	                    sortedFields.clear();
	                    str.delete(0, str.length());
	                    }
				}
			}
		}
	}
}
					
				
		
		


