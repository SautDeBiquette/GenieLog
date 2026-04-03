package components.smartDevices;

import interfaces.SmartDevice;

import java.sql.Time;

public class SmartBlinds implements SmartDevice {
    private  String serialNumber;
    private String label;
    private boolean isOn;

    private static final String VOLETS = "Les volets [";

    @Override
    public void turnOn() {
        if(this.isOn()) {
            notifyUser(VOLETS + label + "] sont déjà ouvert ");
        } else {
            notifyUser(VOLETS + label + "] s'ouvrent...");
            this.setOn(true);
            try { Thread.sleep(300);} catch (InterruptedException e) {Thread.currentThread().interrupt();}
            notifyUser(VOLETS + label + "] sont ouverts ");
        }
    }

    @Override
    public void turnOff() {
        if(this.isOn()) {
            notifyUser(VOLETS + label + "] se ferment...");
            this.setOn(false);
            try { Thread.sleep(300);} catch (InterruptedException e) {Thread.currentThread().interrupt();}
            notifyUser(VOLETS + label + "] sont fermés ");
        } else {
            notifyUser(VOLETS + label + "] sont déjà fermés ");
        }
    }

    @Override
    public String notifyUser(String message) {
        System.out.println(message);
        return message;
    }

    @Override
    public void schedule(int timeToExecute) {
        try { Thread.sleep(timeToExecute);} catch (InterruptedException e) {Thread.currentThread().interrupt();}
        if(this.isOn()) {
            this.turnOff();
        } else {
            this.turnOn();
        }
    }

    @Override
    public String report() {
        return "SmartBlinds "+ label +"{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public void run(){
        this.schedule(10100);
    }

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
}
