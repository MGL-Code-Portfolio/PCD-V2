package iscot.events.high_level;

import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {
    private boolean isOn;

    public AreaLightingOrderEvent(Areas area, boolean isOn) {
        super(area);
        this.isOn = isOn;
    }

    public boolean getIsOn() { return isOn; }

    @Override
    public String toString() {
        return super.toString() + " - Ordem: " + (isOn ? "ligar" : "desligar") + " luzes";
    }
}
