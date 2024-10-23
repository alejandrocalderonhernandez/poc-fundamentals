package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.MindStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.singletons.MindStoneSingleton;

public class MindStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return MindStoneSingleton.getInstance();
        } else {
            return Prototypes.mindPrototype.buildPrototype(new MindStone());
        }
    }
}
