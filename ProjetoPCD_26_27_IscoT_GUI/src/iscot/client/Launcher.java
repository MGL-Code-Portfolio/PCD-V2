package iscot.client;

import iscot.client.actuators.AirConditioner;
import iscot.client.actuators.Irrigator;
import iscot.client.actuators.Lamp;
import iscot.client.actuators.Ventilator;
import iscot.client.sensors.GroundMoistureSensor;
import iscot.client.sensors.HumiditySensor;
import iscot.client.sensors.LightSensor;
import iscot.client.sensors.TemperatureSensor;
import iscot.enums.Areas;

public class Launcher {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.err.println("Uso: Lancher IP PORT AREA TIPO_DISPOSITIVO");
            return;
        }

        String serverAddress = args[0];
        int serverPort = Integer.parseInt(args[1]);
        Areas area = Areas.valueOf(args[2]);

        Client client = switch (args[3]) {
            case "AirConditioner" -> new AirConditioner(serverAddress, serverPort, area);
            case "Irrigator" -> new Irrigator(serverAddress, serverPort, area);
            case "Lamp" -> new Lamp(serverAddress, serverPort, area);
            case "Ventilator" -> new Ventilator(serverAddress, serverPort, area);
            case "GroundMoistureSensor" -> new GroundMoistureSensor(serverAddress, serverPort, area, 0);
            case "HumiditySensor" -> new HumiditySensor(serverAddress, serverPort, area, 0);
            case "LightSensor" -> new LightSensor(serverAddress, serverPort, area, 0);
            case "TemperatureSensor" -> new TemperatureSensor(serverAddress, serverPort, area, 0);

            default -> null;
        };

        client.start();
    }
}
