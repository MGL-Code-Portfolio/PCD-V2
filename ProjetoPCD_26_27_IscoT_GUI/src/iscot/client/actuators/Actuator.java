
package iscot.client.actuators;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import iscot.client.Client;
import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Actuator extends Client {

    protected final Areas area;

    protected Actuator(String serverAddress,
                       int serverPort,
                       Areas area) {

        super(serverAddress, serverPort, area, Type.ACTUATOR);
        this.area = area;
    }

    // Cada atuador define o seu componente gráfico
    protected abstract JComponent createComponent();

    // Cada atuador define o seu nome
    protected abstract String getActuatorName();

    // Cada atuador define a sua simulação
    protected abstract void simulate();

    // Método comum a todos os atuadores
    public void createGUI() {

        JFrame janela =
                new JFrame(getActuatorName() + " em " + area);

        janela.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        JPanel painel = new JPanel(new BorderLayout());

        // Obtém o componente da classe filha
        JComponent component = createComponent();

        painel.add(component, BorderLayout.CENTER);

        janela.setContentPane(painel);
        janela.pack();
        janela.setMinimumSize(janela.getSize());
        janela.setLocation(600, 400);
        janela.setVisible(true);

        // Simulação local após 5 segundos
        Timer timer = new Timer(5000, e -> simulate());
        timer.setRepeats(false);
        timer.start();
    }
}
