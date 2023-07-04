package com.shopspace.shopspaceservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterUtil {
    private static final String DATE_FORMAT_DB = "yyyy-MM-dd hh:mm:ss";

    public static Date convertStringToDate(String date) {
        Date convert;

        try {
            convert =new SimpleDateFormat(DATE_FORMAT_DB).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("error to convert string to date: "+e);
        }

        return convert;
    }

    public static String convertDateToString(Date date) {
        return date != null ? new SimpleDateFormat(DATE_FORMAT_DB).format(date): "";
    }
}
