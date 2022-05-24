package com.bext.mapConverter;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateMapper {
    private final String DATE_FORMAT1 = "YYYY-MM-dd HH:mm";
    private final DateTimeFormatter DATETIMEFORMATER = DateTimeFormatter.ofPattern(DATE_FORMAT1);

    public LocalDateTime stringAsLocalDateTime(String str) {
        return LocalDateTime.parse( str, DATETIMEFORMATER);
    }

    public String localDateTimeAsString( LocalDateTime dateTime) {
        return dateTime.format(DATETIMEFORMATER);
    }

}
