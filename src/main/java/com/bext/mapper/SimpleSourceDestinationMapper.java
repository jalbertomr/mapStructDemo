package com.bext.mapper;

import com.bext.pojo.SimpleDestination;
import com.bext.pojo.SimpleSource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    SimpleSourceDestinationMapper INSTANCE = Mappers.getMapper(SimpleSourceDestinationMapper.class);
    SimpleDestination simpleSourceToSimpleDestination( SimpleSource source);
    SimpleSource simpleDestinationToSimpleSource( SimpleDestination simpleDestination);
}
