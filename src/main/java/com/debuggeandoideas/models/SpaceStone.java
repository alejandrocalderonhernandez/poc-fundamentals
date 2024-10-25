package com.debuggeandoideas.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class SpaceStone extends Stone {

    private static final String COLOR = "Blue";
    private static final String NAME = "Space Stone";
    private static final String LOCATION = "Tesseract";
    private static final int ENERGY_LEVEL = 7;

    public SpaceStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        System.out.println("Manipulate all space " + super.color);
    }

    public SpaceStone getPrototype() {
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
                return (SpaceStone) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
