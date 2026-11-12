
package iscot.client.actuators;

import javax.swing.JComponent;

import iscot.enums.Areas;
import iscot.client.gui.IrrigationIcon;

public class Irrigator extends Actuator {

    private IrrigationIcon irrigator;

    public Irrigator(String serverAddress,
                     int serverPort,
                     Areas area) {
        super(serverAddress, serverPort, area);
    }

    @Override
    protected JComponent createComponent() {
        irrigator = new IrrigationIcon();
        return irrigator;
    }

    @Override
    protected String getActuatorName() {
        return "Irrigador";
    }

    @Override
    protected void simulate() {
        irrigator.setAtivo(true);
        irrigator.repaint();

        System.out.println("Rega ativada");
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
            return;
        }

        Areas area = Areas.valueOf(args[2]);

        Irrigator irrigator = new Irrigator(
                args[0],
                Integer.parseInt(args[1]),
                area
        );

        irrigator.createGUI();
    }
}
