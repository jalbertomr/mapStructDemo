package com.bext.dto;

import com.bext.enums.FurType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FurryStuff {
    private String fullName;
    private FurType furtype;
}
