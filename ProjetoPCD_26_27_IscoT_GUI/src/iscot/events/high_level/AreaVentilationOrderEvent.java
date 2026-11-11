package iscot.events.high_level;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {
    private boolean isOn;

    public AreaVentilationOrderEvent(Areas area, boolean isOn) {
        super(area);
        this.isOn = isOn;
    }

    public boolean getIsOn() { return isOn; }

    @Override
    public String toString() {
        return super.toString() + " - Ordem: " + (isOn ? "ligar" : "desligar") + " ventilação";
    }
}
