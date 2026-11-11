package iscot.events.sensor_events;

import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent {
    public LightSensorEvent(Areas area, double luminosity) {
        super(area, luminosity);
    }

    @Override
    public String toString() {
        return super.toString() + " - Luz: " + getValue() + " lux";
    }
}
