package com.debuggeandoideas.factories;

import com.debuggeandoideas.models.PowerStone;
import com.debuggeandoideas.models.Stone;
import com.debuggeandoideas.models.TimeStone;
import com.debuggeandoideas.protoypes.Prototypes;
import com.debuggeandoideas.singletons.PowerStoneSingleton;
import com.debuggeandoideas.singletons.TimeStoneSingleton;

public class TimeStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return TimeStoneSingleton.getInstance();
        } else {
            return Prototypes.timePrototype.buildPrototype(new TimeStone());
        }
    }
}
