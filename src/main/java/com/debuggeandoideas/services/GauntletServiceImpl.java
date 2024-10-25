package com.debuggeandoideas.services;

import com.debuggeandoideas.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.NoSuchElementException;

//@Service
@Log
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GauntletServiceImpl implements GauntletService {


    private RealityStone reality;
    private SoulStone soul;
    private MindStone mind;
    private PowerStone power;
    private SpaceStone space;
    private TimeStone time;


    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "reality" -> log.info("Use stone: " + this.reality);
            case "soul" -> log.info("Use stone: " + this.soul);
            case "mind" -> log.info("Use stone: " + this.mind);
            case "power" -> log.info("Use stone: " +this.power);
            case "space" -> log.info("Use stone: " + this.space);
            case "time" -> log.info("Use stone: " + this.time);

            default -> throw new IllegalArgumentException("Invalid name");
        }
    }

    @Override
    public void useFullPower() {

        if (this.time != null && this.reality != null &&
                this.space != null  && this.mind != null
                && this.power != null && this.soul != null ) {
            log.info("USING ALL POWER");
        } else {
            throw new IllegalStateException("Cant be using full power because service have field null");
        }
    }

    //DI by fields
   public void setStones(Map<String, Stone> stones) {
        stones.forEach((fieldName, stoneDependency) -> {
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, stoneDependency); //Dependency Injection
                log.info("Dependency Injection by field" + fieldName);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.warning("Error on DI by fields");
            }
        });
   }

}
