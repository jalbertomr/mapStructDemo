package com.bext.mapper;

import com.bext.dto.AddressDto;
import com.bext.dto.CustomerDto;
import com.bext.entity.Address;
import com.bext.entity.Customer;
import com.bext.entity.CustomerType;
import com.bext.entity.Title;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
class CustomerMapperTest {

    @Test
    void customerToDto() throws ParseException {
        //given
        Title title = new Title(23L, "Cibernetica", "ULSA");
        LocalDate localDate = LocalDate.of(2022, 02, 22);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-12-02 13:30:05");
        Address address = new Address("CDMX", "main Street");
        BigDecimal credit = new BigDecimal(9999999.99);
        Customer customer = new Customer(1L, "Jose Alberto", "Martinez", title, localDate,
                credit, CustomerType.FOREIGN, address, date);
        //when
        CustomerDto customerDto = CustomerMapper.INSTANCE.customerToDto(customer);
        //then
        log.info("customer {}", customer);
        log.info("customerDto {}", customerDto);
        Assertions.assertEquals(1L, customerDto.customerId);
        Assertions.assertEquals("Cibernetica", customerDto.getTitle());
        Assertions.assertEquals("2022-02-22", customerDto.getDateOfBirth());
        //Assertions.assertEquals( credit, customerDto.getCreditScore());
        Assertions.assertEquals( address.getCity(), customerDto.getAddress().getCity());
        Assertions.assertEquals( address.getStreet(), customerDto.getAddress().getStreet());
        Assertions.assertEquals( customer.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                customerDto.getDateOfBirth());
        Assertions.assertEquals( "Jose Alberto Martinez", customerDto.getFullName());
    }

    @Test
    void customerDtoToCustomerTest() {
        //given
        LocalDate creationLocalDate = LocalDate.of(2022, 12,01);
        AddressDto addressDto = new AddressDto( "main Street", "CDMX");
        CustomerDto customerDto = new CustomerDto( 22L, "Jose Alberto Martinez", 1234567.12,
                "1970-12-02", creationLocalDate, "Cibernetica", addressDto);
        //when
        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(customerDto);
        log.info("customerDto {}", customerDto);
        log.info("customer {}", customer);
        //then
    }
}