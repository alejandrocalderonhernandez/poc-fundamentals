package com.debuggeandoideas.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class MindStone extends Stone {


    private static final String COLOR = "Yellow";
    private static final String NAME = "Mind Stone";
    private static final String LOCATION = "Scepter";
    private static final int ENERGY_LEVEL = 4;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        //Business logic
        System.out.println("Mind control in stone: " + super.toString());
    }

    public MindStone getPrototype() {
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
                return (MindStone) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }

}
