package com.debuggeandoideas.singletons;

import com.debuggeandoideas.models.PowerStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PowerStoneSingleton {

    private static volatile PowerStone powerStoneInstance;

    public static PowerStone getInstance() {
        if (powerStoneInstance == null) {
            log.info("Creating first instance: " + PowerStoneSingleton.class);
            synchronized (MindStoneSingleton.class) {
                if (powerStoneInstance == null) {
                    powerStoneInstance = new PowerStone();
                }
            }
        }
        return powerStoneInstance;
    }
}
