package components.smartDevices;

import interfaces.SmartDevice;

public class SmartFoodDispenser implements SmartDevice, Runnable {
    private String serialNumber;
    private String label;
    private boolean isOn;


    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser("Le distributeur de nourriture [" + label + "] est déjà en train de distribuer ");
        } else {
            notifyUser("Le distributeur de nourriture [" + label + "] distribue une portion...");
            this.setOn(true);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("Le distributeur de nourriture [" + label + "] a terminé la distribution ");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            notifyUser("Le distributeur de nourriture [" + label + "] s'arrête... ");
            this.setOn(false);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("Le distributeur de nourriture [" + label + "] est arrêté ");
        } else {
            notifyUser("Le distributeur de nourriture [" + label + "] n'est pas en cours de fonctionnement ");
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
        return "SmartFoodDispenser " + label + "{" +
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