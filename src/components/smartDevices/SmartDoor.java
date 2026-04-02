package components.smartDevices;

import interfaces.SmartDevice;

public class SmartDoor implements SmartDevice, Runnable {
    private String serialNumber;
    private String label;
    private boolean isOn;


    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser("La porte [" + label + "] est déjà ouverte ");
        } else {
            notifyUser("La porte [" + label + "] s'ouvre...");
            this.setOn(true);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("La porte [" + label + "] est maintenant ouverte ");
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            notifyUser("La porte [" + label + "] se ferme...");
            this.setOn(false);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("La porte [" + label + "] est fermée ");
        } else {
            notifyUser("La porte [" + label + "] est déjà fermée ");
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
        return "SmartDoor " + label + "{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
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

}