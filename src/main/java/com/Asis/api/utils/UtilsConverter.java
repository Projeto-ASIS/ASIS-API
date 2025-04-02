package com.Asis.api.utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class UtilsConverter {

    public static String dateTimeConverter(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
