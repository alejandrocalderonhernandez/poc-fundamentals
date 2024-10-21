package com.debuggeandoideas.singletons;

import com.debuggeandoideas.models.SoulStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SoulStoneInstance {

    private static volatile SoulStone soulStoneInstance;

    public static SoulStone getInstance() {
        if (soulStoneInstance == null) {
            log.info("Creating first instance: " + MindStoneSingleton.class);
            synchronized (MindStoneSingleton.class) {
                if (soulStoneInstance == null) {
                    soulStoneInstance = new SoulStone();
                }
            }
        }
        return soulStoneInstance;
    }
}
