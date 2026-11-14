package iscot.client.sensors;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor_events.SensorEvent;
import iscot.events.sensor_events.TemperatureSensorEvent;

public class TemperatureSensor extends Sensor {
    private double temperature;

    public TemperatureSensor(String serverAddress, int serverPort, Areas area, double temperature) {
        super(serverAddress, serverPort, area);
        this.temperature = temperature;
    }

    public double getTemperature() { return temperature; }

    @Override
    protected SensorControl createSensorControl() {
        return new SensorControl("", "", "",
                0, 2000, 10, 30,
                this::onValueChanged);
    }

    protected SensorEvent createSensorEvent(double value) {
        return new TemperatureSensorEvent(getArea(), value);
    }

    @Override
    protected void onValueChanged(double temperature) {
        this.temperature = temperature;
        super.onValueChanged(temperature);
    }

    @Override
    protected void createGUI() {
        createSensorWindow("Temperatura", "\uD83C\uDF21", "ºC",
                0, 2000, 10, 30);
    }
}
