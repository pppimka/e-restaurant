package com.bionic.webrestaurant.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DatePersistanceConverter implements
		AttributeConverter<java.util.Date, java.sql.Date> {

	@Override
	public java.sql.Date convertToDatabaseColumn(java.util.Date entityValue) {
		if (entityValue != null) {
			return new java.sql.Date(entityValue.getTime());
		}
		return null;
	}

	@Override
	public java.util.Date convertToEntityAttribute(java.sql.Date databaseValue) {
		if (databaseValue != null) {
			return new java.util.Date(databaseValue.getTime());
		}
		return null;
	}

}
