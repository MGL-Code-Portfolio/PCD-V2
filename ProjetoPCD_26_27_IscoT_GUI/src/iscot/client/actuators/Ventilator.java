
package iscot.client.actuators;

import javax.swing.JComponent;

import iscot.enums.Areas;
import iscot.gui.VentilatorIcon;

public class Ventilator extends Actuator {

	private VentilatorIcon ventilator;

	public Ventilator(String serverAddress,
					  int serverPort,
					  Areas area) {
		super(serverAddress, serverPort, area);
	}

	@Override
	protected JComponent createComponent() {
		ventilator = new VentilatorIcon();
		return ventilator;
	}

	@Override
	protected String getActuatorName() {
		return "Ventilador";
	}

	@Override
	protected void simulate() {
		ventilator.setAtivo(true);
		ventilator.repaint();

		System.out.println("Ventilador ligado");
	}

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}

		Areas area = Areas.valueOf(args[2]);

		Ventilator ventilator = new Ventilator(
				args[0],
				Integer.parseInt(args[1]),
				area
		);

		ventilator.createGUI();
	}
}
