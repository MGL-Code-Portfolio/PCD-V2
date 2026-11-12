
package iscot.client.actuators;

import javax.swing.JComponent;

import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.high_level.AreaLightingOrderEvent;

public class Lamp extends Actuator {

    private LightIcon lamp;

    public Lamp(String serverAddress, int serverPort,
                Areas area) {
        super(serverAddress, serverPort, area);
    }

    @Override
    protected JComponent createComponent() {
        lamp = new LightIcon();
        return lamp;
    }

    @Override
    protected String getActuatorName() {
        return "Lâmpada";
    }

    @Override
    protected void simulate() {

        AreaLightingOrderEvent evento =
                new AreaLightingOrderEvent(area, true);

        System.out.println(evento);

        lamp.setLigada(evento.getIsOn());
        lamp.repaint();
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
            return;
        }

        Areas area = Areas.valueOf(args[2]);

        Lamp lamp = new Lamp(
                args[0],
                Integer.parseInt(args[1]),
                area
        );

        lamp.createGUI();
    }
}
