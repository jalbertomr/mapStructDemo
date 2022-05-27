package com.bext.mapConverter;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DateConverter {
    private final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final DateTimeFormatter DATETIMEFORMATER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

    public Date strDateTimeToDate(String strDateTime) throws ParseException {
       return new SimpleDateFormat(DATETIME_FORMAT).parse(strDateTime);
    };

    public String dateToStrDateTime(Date date){ return new SimpleDateFormat( DATETIME_FORMAT).format( date);
    }

    public LocalDateTime stringAsLocalDateTime(String str) {
        return LocalDateTime.parse( str, DATETIMEFORMATER);
    }

    public String localDateTimeAsString( LocalDateTime dateTime) {
        return dateTime.format(DATETIMEFORMATER);
    }

    public Date localDateTimeToDate(LocalDateTime localDateTime){
        return //java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Timestamp.valueOf(localDateTime);
    }

    public LocalDateTime dateToLocalDateTime( Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
