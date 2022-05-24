package com.bext.mapper;

import com.bext.dto.FurryStuff;
import com.bext.dto.SlimyStuff;
import com.bext.enums.FurType;
import com.bext.enums.SlimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StuffMapperTest {

    @Test
    void slimeToFurTest_CORROSIVE_to_POINTY() {
        //given
        SlimeType slime = SlimeType.CORROSIVE;
        //when
        FurType furType = StuffMapper.INSTANCE.slimeToFur( slime);
        //then
        Assertions.assertEquals(FurType.POINTY, furType);
    }

    @Test
    void slimeToFurTest_NULL_to_GREASY() {
        //given
        SlimeType slime = null;
        //when
        FurType furType = StuffMapper.INSTANCE.slimeToFur( slime);
        //then
        Assertions.assertEquals(FurType.GREASY, furType);
    }

    @Test
    void slimeToFurTest_ANYREMAINING_to_LONG() {
        //given
        SlimeType slime = SlimeType.SMELLY;
        //when
        FurType furType = StuffMapper.INSTANCE.slimeToFur( slime);
        //then
        Assertions.assertEquals(FurType.LONG, furType);
    }

    @Test
    void slimyToFurryTest_CORROSIVE_to_POINTY() {
        //given
        SlimyStuff naOH = new SlimyStuff("NaOH", SlimeType.CORROSIVE);
        //when
        FurryStuff furryStuff = StuffMapper.INSTANCE.slimyToFurry(naOH);
        //then
        Assertions.assertEquals(FurType.POINTY, furryStuff.getFurtype());
    }

    @Test
    void slimyToFurryTest_NULL_to_GREASY() {
        //given
        SlimyStuff naOH = new SlimyStuff("NaOH", null);
        //when
        FurryStuff furryStuff = StuffMapper.INSTANCE.slimyToFurry(naOH);
        //then
        Assertions.assertEquals(FurType.GREASY, furryStuff.getFurtype());
    }

    @Test
    void slimyToFurryTest_ANYREMAINING_to_LONG() {
        //given
        SlimyStuff naOH = new SlimyStuff("NaOH", SlimeType.SMELLY);
        //when
        FurryStuff furryStuff = StuffMapper.INSTANCE.slimyToFurry(naOH);
        //then
        Assertions.assertEquals(FurType.LONG, furryStuff.getFurtype());
    }
}