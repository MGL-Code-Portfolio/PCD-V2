package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Event {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Areas area;
    private LocalDateTime timestamp;
    private Type type;

    protected Event(Areas area, Type type) {
        this.area = area;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public Areas getArea() { return area; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return "[" + timestamp.format(DTF) + "]" + area.toString();
    }
}
