package components.smartDevices;

import interfaces.SmartDevice;

public class SmartThermometer implements SmartDevice, Runnable {
    private String serialNumber;
    private String label;
    private boolean isOn;


    @Override
    public void turnOn() {
        if (this.isOn()) {
            notifyUser("Le thermomètre [" + label + "] est déjà en cours de mesure ");
        } else {
            notifyUser("Le thermomètre [" + label + "] démarre une mesure...");
            this.setOn(true);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("Le thermomètre [" + label + "] a terminé la mesure ");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn()) {
            System.out.println("Le thermomètre [" + label + "] s'éteint... ");
            this.setOn(false);
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            notifyUser("Le thermomètre [" + label + "] est éteint ");
        } else {
            System.out.println("Le thermomètre [" + label + "] est déjà éteint ");
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