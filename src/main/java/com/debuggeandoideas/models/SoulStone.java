package com.debuggeandoideas.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString
@Log
public class SoulStone extends Stone {

    private static final String COLOR = "Orange";
    private static final String NAME = "Soul Stone";
    private static final String LOCATION = "Vormir";
    private static final int ENERGY_LEVEL = 3;

    public SoulStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        System.out.println("Total control: " + super.toString());
    }

    public SoulStone getPrototype() {
        try (
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos)
        ) {

            //Serialize and clone
            oos.writeObject(this);
            oos.flush();

            try (
                    final var bis = new ByteArrayInputStream(bos.toByteArray());
                    final var ois = new ObjectInputStream(bis)
            ) {

                // Return and Casting
                return (SoulStone) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
