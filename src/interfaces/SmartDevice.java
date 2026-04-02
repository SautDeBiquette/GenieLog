package interfaces;

public interface SmartDevice extends Runnable {
    void turnOn();

    void turnOff();

    String notifyUser(String message);

    void schedule(int timeToExecute);

    String report();
}
