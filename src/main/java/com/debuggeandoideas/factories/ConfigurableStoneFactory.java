package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.Stone;
import lombok.extern.java.Log;

import java.util.Optional;

@Log
public abstract class ConfigurableStoneFactory {

    public abstract Stone createStone();

    protected boolean isSingleton() {
        final var scopeOpt = Optional.of(System.getProperty("scope"));


        final var scope = scopeOpt.orElse("singleton");

        log.info("scope: " + scope);
        return "singleton".equals(scope);
    }
}
