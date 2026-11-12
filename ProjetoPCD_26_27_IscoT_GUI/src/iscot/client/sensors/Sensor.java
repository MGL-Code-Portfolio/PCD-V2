package iscot.client.sensors;

import iscot.client.Client;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.sensor_events.SensorEvent;

public abstract class Sensor extends Client {
    protected Sensor(String serverAddress, int serverPort, Areas area) {
        super(serverAddress, serverPort, area, Type.SENSOR);
    }

    protected abstract SensorControl createSensorControl();
    protected abstract SensorEvent createSensorEvent(double value);

    protected void onValueChanged(double value) {
        SensorEvent event = createSensorEvent(value);
        System.out.println(event);
    }

    protected void createSensorWindow(String name, String icon, String unit,
                                      double min, double max, double step, double initial) {

    }
}
