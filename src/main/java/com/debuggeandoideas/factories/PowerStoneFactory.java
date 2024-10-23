package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.PowerStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.singletons.PowerStoneSingleton;

public class PowerStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return PowerStoneSingleton.getInstance();
        } else {
            return Prototypes.powerPrototype.buildPrototype(new PowerStone());
        }
    }
}
