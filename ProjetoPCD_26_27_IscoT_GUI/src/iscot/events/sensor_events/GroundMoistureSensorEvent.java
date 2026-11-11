package iscot.events.sensor_events;

import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent{
    public GroundMoistureSensorEvent(Areas area, double humidity) {
        super(area, humidity);
    }

    @Override
    public String toString() {
        return super.toString() + " - Humidade do Chão: " + getValue() + " %";
    }
}
