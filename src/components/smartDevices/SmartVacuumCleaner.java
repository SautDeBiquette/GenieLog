package components.smartDevices;

import interfaces.SmartDevice;

public class SmartVacuumCleaner implements SmartDevice {
    private String serialNumber;
    private String label;
    private boolean isOn;

    private static final String ASPIRATEUR = "L'aspirateur [" ;

    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser(ASPIRATEUR + label + "] est déjà en train d'aspirer ");
        } else {
            notifyUser(ASPIRATEUR + label + "] démarre un cycle de nettoyage...");
            this.setOn(true);
            try { Thread.sleep(600); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(ASPIRATEUR + label + "] a terminé le cycle de nettoyage ");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            notifyUser(ASPIRATEUR + label + "] s'arrête... ");
            this.setOn(false);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser(ASPIRATEUR + label + "] est arrêté ");
        } else {
            notifyUser(ASPIRATEUR + label + "] n'est pas en cours de fonctionnement ");
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
        return "SmartVacuumCleaner " + label + "{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public void run() {
        this.schedule(11110);
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