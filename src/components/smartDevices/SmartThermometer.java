package components.smartDevices;

import interfaces.SmartDevice;

public class SmartThermometer implements SmartDevice {
    private String serialNumber;
    private String label;
    private boolean isOn;
    private double temperature;

    private static final String THERMOMETRE = "Le thermomètre [" ;

    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser(THERMOMETRE + label + "] est déjà en cours de mesure ");
        } else {
            notifyUser(THERMOMETRE + label + "] démarre une mesure...");
            this.setOn(true);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(THERMOMETRE + label + "] a terminé la mesure ");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            System.out.println(THERMOMETRE + label + "] s'éteint... ");
            this.setOn(false);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(THERMOMETRE + label + "] est éteint ");
        } else {
            System.out.println(THERMOMETRE + label + "] est déjà éteint ");
        }
    }

    @Override
    public String notifyUser(String message) {
        System.out.println(message);
        return message;
    }

    @Override
    public void schedule(int timeToExecute) {
        try { Thread.sleep(timeToExecute); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        if (this.isOn()) { this.turnOff(); } else { this.turnOn(); }
    }

    @Override
    public String report() {
        return "SmartThermometer " + label + "{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
                ", temperature=" + temperature +
                '}';
    }

    @Override
    public void run() {}

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public boolean isOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}