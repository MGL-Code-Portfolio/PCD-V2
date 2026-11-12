package iscot.client.sensors;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor_events.LightSensorEvent;
import iscot.events.sensor_events.SensorEvent;

public class LightSensor extends Sensor {
    public double value;

    public LightSensor(String serverAddress, int serverPort, Areas area, double value) {
        super(serverAddress, serverPort, area);
        this.value = value;
    }

    public double getValue() { return value; }


    @Override
    protected SensorControl createSensorControl() {
        return new SensorControl("", "", "",
                0, 2000, 10, 30,
                this::onValueChanged);
    }

    protected SensorEvent createSensorEvent(double value) {
        return new LightSensorEvent(getArea(), value);
    }

    @Override
    protected void onValueChanged(double value) {
        this.value = value;
        super.onValueChanged(value);
    }

    @Override
    protected void createGUI() {
        createSensorWindow("Luz ", "Icon", "lux", 0, 2000, 10, 30);
    }
}
