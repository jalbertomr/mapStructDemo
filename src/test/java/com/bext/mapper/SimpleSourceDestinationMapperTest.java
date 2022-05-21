package com.bext.mapper;

import com.bext.pojo.SimpleDestination;
import com.bext.pojo.SimpleSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

@Slf4j
class SimpleSourceDestinationMapperTest {

    @Test
    void sourceToDestination1() {
        SimpleSource simpleSource = new SimpleSource("Jose Alberto", "Description Jose");

        SimpleSourceDestinationMapper simpleToSource = Mappers.getMapper(SimpleSourceDestinationMapper.class);
        SimpleDestination simpleDestination = simpleToSource.simpleSourceToSimpleDestination(simpleSource);

        Assertions.assertEquals(simpleSource.getName(), simpleDestination.getName());
        Assertions.assertEquals(simpleSource.getDescription(), simpleDestination.getDescription());
    }

    @Test
    void sourceToDestination2() {
        SimpleSource simpleSource = new SimpleSource("Jose Alberto", "Description Jose");

        SimpleDestination simpleDestination = SimpleSourceDestinationMapper.INSTANCE.simpleSourceToSimpleDestination(simpleSource);

        Assertions.assertEquals(simpleSource.getName(), simpleDestination.getName());
        Assertions.assertEquals(simpleSource.getDescription(), simpleDestination.getDescription());
    }

    @Test
    void destinationToSource() {

    }
}