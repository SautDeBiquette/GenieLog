package interfaces;

import java.sql.Time;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    String notifyUser(String message);
    void schedule(int timeToExecute);
    String report();
}
