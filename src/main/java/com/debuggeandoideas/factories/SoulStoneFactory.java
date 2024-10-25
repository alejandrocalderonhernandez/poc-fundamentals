package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.SoulStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.singletons.SoulStoneSingleton;

public class SoulStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {
        if(super.isSingleton()) {
            return SoulStoneSingleton.getInstance();
        } else {
            return Prototypes.soulPrototype.buildPrototype(new SoulStone());
        }
    }
}
