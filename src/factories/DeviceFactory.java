package factories;

import interfaces.SmartDevice;

import java.sql.Time;

public abstract class DeviceFactory {
    private int serialNumber;
    private String label;
    private Time schedule;

    public abstract SmartDevice createSmartDevice();

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Time getSchedule() {
        return schedule;
    }

    public void setSchedule(Time schedule) {
        this.schedule = schedule;
    }
}
