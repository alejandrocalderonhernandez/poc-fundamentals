package com.debuggeandoideas.singletons;

import com.debuggeandoideas.models.MindStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MindStoneSingleton {

    private static volatile MindStone mindStoneInstance;

    public static MindStone getInstance() {
        if (mindStoneInstance == null) {
            log.info("Creating first instance: " + MindStoneSingleton.class);
             synchronized (MindStoneSingleton.class) {
                 if (mindStoneInstance == null) {
                     mindStoneInstance = new MindStone();
                 }
             }
        }
        return mindStoneInstance;
    }

}
