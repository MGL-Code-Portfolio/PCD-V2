package iscot.events.sensor_events;

import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent {
    public HumiditySensorEvent(Areas area, double humidity) {
        super(area, humidity);
    }

    @Override
    public String toString() {
        return super.toString() + " - Humidade: " + getValue() + " %";
    }
}
