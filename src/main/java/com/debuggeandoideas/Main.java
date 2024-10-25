package com.debuggeandoideas;

import com.debuggeandoideas.configs.StoneContext;

public class Main {


    public static void main(String[] args) {

        final var gauntletService = StoneContext.setContext(
            pre -> System.out.println("Do something 1"),
            post -> System.out.println("Do something 2")
        );

        gauntletService.useGauntlet("power");

        gauntletService.useFullPower();

        StoneContext.destroyContext(gauntletService);
    }
}