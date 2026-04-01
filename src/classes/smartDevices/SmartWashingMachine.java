package classes.smartDevices;

import interfaces.SmartDevice;

import java.sql.Time;

public class SmartWashingMachine implements SmartDevice {
    private String serialNumber;
    private String label;
    private boolean isOn;
    private Time schedule;

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

    public Time getSchedule() {
        return schedule;
    }

    public void setSchedule(Time schedule) {
        this.schedule = schedule;
    }
    @Override
    public void turnOn() {
        this.setOn(true);
    }

    @Override
    public void turnOff() {
        this.setOn(false);
    }

    @Override
    public String notifyUser() {
        return "";
    }

    @Override
    public String schedule(Time timeScheduled) {
        return "";
    }

    @Override
    public String report() {
        return "";
    }
}
