package com.debuggeandoideas.models;

public class SoulStone extends Stone {

    private static final String COLOR = "Orange";
    private static final String NAME = "Soul Stone";
    private static final String LOCATION = "Vormir";
    private static final int ENERGY_LEVEL = 3;

    public SoulStone(String color, String name, String location, Integer energyLevel) {
        super(color, name, location, energyLevel);
    }

    @Override
    public void usePower() {

    }
}
