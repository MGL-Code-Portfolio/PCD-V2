package iscot.client.sensors;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor_events.GroundMoistureSensorEvent;
import iscot.events.sensor_events.HumiditySensorEvent;
import iscot.events.sensor_events.SensorEvent;

public class HumiditySensor extends Sensor {
	public double humidity;

	public HumiditySensor(String serverAddress, int serverPort, Areas area, double humidity) {
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
		return new HumiditySensorEvent(getArea(), value);
	}

	@Override
	protected void onValueChanged(double humidity) {
		this.humidity = humidity;
		super.onValueChanged(humidity);
	}

	@Override
	protected void createGUI() {
		createSensorWindow("Humidade", "\uD83D\uDCA7", "%",
				0, 2000, 10, 30);
	}

	/*
	 * 
	 * @param server address and port
	 * @param roomName: string
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws NumberFormatException 
	 * @throws InterruptedException 

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			// TODO connect to the server

			// TODO register with the server
			Areas area=Areas.valueOf(args[2]);
			

			JFrame janela = new JFrame("Humidade em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl= new SensorControl( "☀", "Humidade - "+area, "%",
				    0, 100, 1, 50,
				    valor -> {
				    	// TODO handle change in sensor
				    	System.out.println("Mudou para:"+valor);
				    });
			painel.add(sensorControl,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
		}
	}*/

}
