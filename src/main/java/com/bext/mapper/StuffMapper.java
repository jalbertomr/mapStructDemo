package com.bext.mapper;

import com.bext.dto.FurryStuff;
import com.bext.enums.SlimeType;
import com.bext.dto.SlimyStuff;
import com.bext.enums.FurType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StuffMapper {
    StuffMapper INSTANCE = Mappers.getMapper( StuffMapper.class);

    @ValueMappings({
            @ValueMapping(source="CORROSIVE", target="POINTY"),
            @ValueMapping(source="STICKY", target="SHORT"),
            @ValueMapping(source="SALTY", target="FLAT"),
            @ValueMapping(source= MappingConstants.ANY_REMAINING, target="LONG"),
            @ValueMapping(source=MappingConstants.NULL, target="GREASY"),
    })
    public FurType slimeToFur(SlimeType slime);

    @Mapping(source = "slimeType", target ="furtype" )
    public FurryStuff slimyToFurry(SlimyStuff slimy);
}
