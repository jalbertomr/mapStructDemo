package com.bext.controller;

import com.bext.dto.FurryStuff;
import com.bext.dto.SlimyStuff;
import com.bext.mapper.StuffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StuffRestController {
    private final StuffMapper stuffMapper;

    @GetMapping("/furry")
    public FurryStuff furry(){
        SlimyStuff slimy = new SlimyStuff("OneStuff", null);
        FurryStuff furryStuff = stuffMapper.slimyToFurry(slimy);
        return furryStuff;
    }

}

