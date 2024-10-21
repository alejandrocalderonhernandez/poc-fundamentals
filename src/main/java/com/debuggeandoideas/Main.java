package com.debuggeandoideas;

import com.debuggeandoideas.models.MindStone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.services.GauntletServiceImpl;
import com.debuggeandoideas.singletons.MindStoneSingleton;

public class Main {


    public static void main(String[] args) {

        // Instance 1
        final var mind = new MindStone();

        System.out.println(mind);
        System.out.println(System.identityHashCode(mind));

        // Instance 2
        final var mindProto = mind.getPrototype();
    }
}