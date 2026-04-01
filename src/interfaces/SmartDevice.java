package interfaces;

import java.sql.Time;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    String notifyUser();
    String schedule(Time timeScheduled);
    String report();
}
