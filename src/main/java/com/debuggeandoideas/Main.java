package com.debuggeandoideas;

import com.debuggeandoideas.factories.PowerStoneFactory;
import com.debuggeandoideas.factories.RealityStoneFactory;
import com.debuggeandoideas.factories.TimeStoneFactory;
import com.debuggeandoideas.models.MindStone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.services.GauntletServiceImpl;
import com.debuggeandoideas.singletons.MindStoneSingleton;

public class Main {


    public static void main(String[] args) {


        System.setProperty("scope", "prototype");

        final var timeStoneFactory = new TimeStoneFactory();
        var timeStone = timeStoneFactory.createStone();

        final var powerStoneFactory = new PowerStoneFactory();
        var powerStone = powerStoneFactory.createStone();

        final var realityStoneFactory = new RealityStoneFactory();
        var realityStone = realityStoneFactory.createStone();


        System.out.println(powerStone);
        System.out.println(realityStone);
        System.out.println(timeStone);
    }
}