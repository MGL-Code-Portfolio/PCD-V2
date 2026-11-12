package iscot.client;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Client {
    private String serverAddress;
    private int serverPort;
    private Areas area;
    private Type type;

    protected Client(String serverAddress, int serverPort, Areas area, Type type) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.area = area;
        this.type = type;
    }

    public String getServerAddress() { return serverAddress; }
    public int getServerPort() { return serverPort; }
    public Areas getArea() { return area; }
    public Type getType() { return type; }

    protected void createGUI(){}

    public void start(){
        createGUI();
    }
}
