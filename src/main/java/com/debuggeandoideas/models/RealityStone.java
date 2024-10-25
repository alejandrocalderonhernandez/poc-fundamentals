package com.debuggeandoideas.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class RealityStone extends Stone{

    private static final String COLOR = "Red";
    private static final String NAME = "Reality Stone";
    private static final String LOCATION = "Asgard";
    private static final int ENERGY_LEVEL = 6;

    public RealityStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        System.out.println("Alter reality: " + super.toString());
    }


    public RealityStone getPrototype() {
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
                return (RealityStone) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
