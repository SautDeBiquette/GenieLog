package components.smartDevices;

import interfaces.SmartDevice;

public class SmartFoodDispenser implements SmartDevice {
    private String serialNumber;
    private String label;
    private boolean isOn;

    private static final String DISTRIBUTEUR = "Le distributeur de nourriture [" ;

    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser(DISTRIBUTEUR + label + "] est déjà en train de distribuer ");
        } else {
            notifyUser(DISTRIBUTEUR + label + "] distribue une portion...");
            this.setOn(true);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(DISTRIBUTEUR + label + "] a terminé la distribution ");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            notifyUser(DISTRIBUTEUR + label + "] s'arrête... ");
            this.setOn(false);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(DISTRIBUTEUR + label + "] est arrêté ");
        } else {
            notifyUser(DISTRIBUTEUR + label + "] n'est pas en cours de fonctionnement ");
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
    public void run() {
        this.schedule(13100);
        this.schedule(24000);
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