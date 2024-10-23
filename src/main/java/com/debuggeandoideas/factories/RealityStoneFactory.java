package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.MindStone;
import com.debuggeandoideas.models.RealityStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.singletons.MindStoneSingleton;
import com.debuggeandoideas.singletons.RealityStoneSingleton;

public class RealityStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return RealityStoneSingleton.getInstance();
        } else {
            return Prototypes.realtyPrototype.buildPrototype(new RealityStone());
        }
    }
}
