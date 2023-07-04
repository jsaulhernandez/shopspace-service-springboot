package com.shopspace.shopspaceservice.converter;

import com.shopspace.shopspaceservice.util.ConverterUtil;
import jakarta.persistence.AttributeConverter;

import java.util.Date;

public class DateConverter implements AttributeConverter<Date, String> {
    @Override
    public String convertToDatabaseColumn(Date date) {
        return ConverterUtil.convertDateToString(date);
    }

    @Override
    public Date convertToEntityAttribute(String s) {
        return ConverterUtil.convertStringToDate(s);
    }
}
