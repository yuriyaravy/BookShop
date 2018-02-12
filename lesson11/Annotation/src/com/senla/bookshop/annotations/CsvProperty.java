package com.senla.bookshop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.senla.bookshop.annotations.enums.PropertyType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvProperty {
	
	PropertyType propertyType();
	
	int columnNumber();
	
	String keyField() default "id"; 

}
