package com.bext.mapper;

import com.bext.entity.Title;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TitleMapper {
    @Mapping( source="title", target = "name")
    Title strTitleToTitle(String title);
}
