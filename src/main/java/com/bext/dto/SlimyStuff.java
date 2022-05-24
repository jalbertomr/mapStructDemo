package com.bext.dto;

import com.bext.enums.SlimeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlimyStuff {
    private String fullname;
    private SlimeType slimeType;
}
