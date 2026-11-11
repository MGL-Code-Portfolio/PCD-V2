package iscot.events;

import iscot.enums.Areas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Event {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Areas area;
    private LocalDateTime timestamp;

    protected Event(Areas area) {
        this.area = area;
        this.timestamp = LocalDateTime.now();
    }

    public Areas getArea() { return area; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp.format(DTF) + "]" + area.toString();
    }
}
