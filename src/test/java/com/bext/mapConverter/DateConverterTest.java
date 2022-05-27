package com.bext.mapConverter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DateConverterTest {

    @Test     //LocalDateTime -> String
    void LocalDateTimeToStringTest() throws ParseException {
        //given
        LocalDateTime localDateTime = LocalDateTime.of(2021, Month.NOVEMBER,1, 14,45,10);
        //when
        String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
        //then
        log.info("localDate: {}", localDateTime);
        log.info("strDateFormatedFromLocalDate: {}", strDate);
        Assertions.assertEquals(localDateTime, LocalDateTime.parse( strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test    //String -> LocalDateTime
    void StringToLocalDateTimeTest() {
        //given
        String strDate = "2021-12-02 11:13:15";
        //when
        LocalDateTime localDateTime = LocalDateTime.parse( strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //then
        log.info("strDate: {}", strDate);
        log.info("localDateTime: {}", localDateTime);
        Assertions.assertEquals(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
    }

    @Test   // LocalDateTime -> Date
    void localDateTimeToDateTest() {
        //given
        LocalDateTime localDateTime = LocalDateTime.of(2021, 11,1, 14,45,10);
        //when
        Date date = //java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                java.sql.Timestamp.valueOf(localDateTime);
        //then
        log.info("localDateTime: {}", localDateTime);
        log.info("date: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        Assertions.assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    @Test  // Date -> LocalDateTime
    void dateToLocalDateTime() throws ParseException {
        //given
        Date date = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-12-01 13:30:05");
        //when
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        //then
        log.info("date: {}", date);
        log.info("localDateTime: {}", localDateTime);
        Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
    }

    @Test   // String -> Date
    void stringToDateTest() throws ParseException {
        //given
        String strDate = "2021-12-02 11:13:15";
        //when
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
        //then
        log.info("strDate: {}", strDate);
        log.info("date: {}", date);
        Assertions.assertEquals(strDate, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    @Test  // Date to String
    void dateToString() throws ParseException {
        //given
        Date date =  new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-12-01 13:30:05");
        //when
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        //then
        log.info("date: {} ", date);
        log.info("strDate: {}", date, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate));
    }
}