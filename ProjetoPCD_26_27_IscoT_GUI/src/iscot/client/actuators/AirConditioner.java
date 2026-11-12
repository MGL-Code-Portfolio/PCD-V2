
package iscot.client.actuators;

import javax.swing.JComponent;
import javax.swing.Timer;

import iscot.client.gui.ACIcon;
import iscot.enums.Areas;
import iscot.enums.AirConditioningMode;

public class AirConditioner extends Actuator {

    private ACIcon airConditioner;

    public AirConditioner(String serverAddress,
                          int serverPort,
                          Areas area) {
        super(serverAddress, serverPort, area);
    }

    @Override
    protected JComponent createComponent() {
        airConditioner = new ACIcon();
        return airConditioner;
    }

    @Override
    protected String getActuatorName() {
        return "Ar Condicionado";
    }

    @Override
    protected void simulate() {

        // Ligar em modo frio
        airConditioner.setModo(AirConditioningMode.Frio);
        airConditioner.setTemperatura(22);
        airConditioner.repaint();

        System.out.println("AC em modo Frio a 22°C");

        // Após mais 5 segundos: aquecimento
        Timer timer = new Timer(5000, e -> {

            airConditioner.setModo(
                    AirConditioningMode.Aquecimento
            );
            airConditioner.setTemperatura(25);
            airConditioner.repaint();

            System.out.println(
                    "AC em modo Aquecimento a 25°C"
            );

            // Após mais 5 segundos: desligar
            Timer desligar = new Timer(5000, ev -> {

                airConditioner.setModo(
                        AirConditioningMode.Desligado
                );
                airConditioner.repaint();

                System.out.println("AC desligado");
            });

            desligar.setRepeats(false);
            desligar.start();
        });

        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
            return;
        }

        Areas area = Areas.valueOf(args[2]);

        AirConditioner ac = new AirConditioner(
                args[0],
                Integer.parseInt(args[1]),
                area
        );

        ac.createGUI();
    }
}
