package iscot.events.sensor_events;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent {
    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area, temperature);
    }

    @Override
    public String toString() {
        return super.toString() + " - Temperatura: " + getValue() + " ºC";
    }
}
