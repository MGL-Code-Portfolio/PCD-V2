package iscot.events.high_level;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent{
    private AirConditioningMode mode;
    private double temperature;

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double temperature) {
        super(area);
        this.mode = mode;
        this.temperature = temperature;
    }

    public AirConditioningMode getMode() { return mode; }

    public double getTemperature() { return temperature; }

    @Override
    public String toString() {
        return super.toString() + " - Ordem: AC em " + mode + " a " + temperature + " ºC";
    }
}
