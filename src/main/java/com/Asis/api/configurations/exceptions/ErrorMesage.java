package com.Asis.api.configurations.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record ErrorMesage( String mesage, String time) {

    public ErrorMesage(String mesage){
        this(
            mesage,
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
        );
    }
}
