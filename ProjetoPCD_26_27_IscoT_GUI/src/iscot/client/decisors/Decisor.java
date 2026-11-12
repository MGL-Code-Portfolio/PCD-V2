package iscot.client.decisors;

import iscot.client.Client;
import iscot.enums.Areas;
import iscot.enums.Type;

public class Decisor extends Client {
    public Decisor(String serverAdress, int serverPort, Areas area) {
        super(serverAdress, serverPort, area, Type.DECIDER);
    }
}
