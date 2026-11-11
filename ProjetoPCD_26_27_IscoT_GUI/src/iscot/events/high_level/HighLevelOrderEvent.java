package iscot.events.high_level;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class HighLevelOrderEvent extends Event {
    protected HighLevelOrderEvent(Areas area) {
        super(area, Type.DECIDER);
    }
}
