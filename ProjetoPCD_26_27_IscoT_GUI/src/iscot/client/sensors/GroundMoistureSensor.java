package iscot.client.sensors;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor_events.GroundMoistureSensorEvent;
import iscot.events.sensor_events.SensorEvent;

public class GroundMoistureSensor extends Sensor {
    public double humidity;

    public GroundMoistureSensor(String serverAddress, int serverPort, Areas area, double humidity) {
        super(serverAddress, serverPort, area);
        this.humidity = humidity;
    }

    public double getHumidity() { return humidity; }

    @Override
    protected SensorControl createSensorControl() {
        return new SensorControl("", "", "",
                0, 2000, 10, 30,
                this::onValueChanged);
    }

    protected SensorEvent createSensorEvent(double value) {
        return new GroundMoistureSensorEvent(getArea(), value);
    }

    @Override
    protected void onValueChanged(double humidity) {
        this.humidity = humidity;
        super.onValueChanged(humidity);
    }

    @Override
    protected void createGUI() {
        createSensorWindow("Humidade do solo", "\uD83C\uDF31", "%",
                0, 2000, 10, 30);
    }
}
