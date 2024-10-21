package com.debuggeandoideas.singletons;

import com.debuggeandoideas.models.TimeStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeStoneSingleton {

    private static volatile TimeStone timeStoneInstance;

    public static TimeStone getInstance() {
        if (timeStoneInstance == null) {
            log.info("Creating first instance: " + MindStoneSingleton.class);
            synchronized (MindStoneSingleton.class) {
                if (timeStoneInstance == null) {
                    timeStoneInstance = new TimeStone();
                }
            }
        }
        return timeStoneInstance;
    }
}
