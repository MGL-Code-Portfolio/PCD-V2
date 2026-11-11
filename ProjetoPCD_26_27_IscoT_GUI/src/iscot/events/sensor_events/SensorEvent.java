package iscot.events.sensor_events;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class SensorEvent extends Event {
    private double value;

    public SensorEvent(Areas area, double value) {
        super(area, Type.SENSOR);
        this.value = value;
    }

    public double getValue() { return value; }
}
