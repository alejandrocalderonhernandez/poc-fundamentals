package com.debuggeandoideas.services;

import com.debuggeandoideas.models.RealityStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.singletons.MindStoneSingleton;
import lombok.extern.java.Log;

//@Service
@Log
public class GauntletServiceImpl implements GauntletService {

    private final Stone reality= MindStoneSingleton.getInstance();

    @Override
    public void useGauntlet(String stoneName) {
        log.info("Use stone: " + reality);
    }
}
