package components.smartDevices;

import interfaces.SmartDevice;

public class SmartCoffeeMachine implements SmartDevice {
    private String serialNumber;
    private String label;
    private boolean isOn;

    @Override
    public void turnOn() {
        if (!this.isOn()) {
            notifyUser("la machine à café [" + label + "] se réveille");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.setOn(true);
        notifyUser("la machine à café [" + label + "] fait un café... ");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        notifyUser("la machine à café [" + label + "] à fini de faire un café");
    }

    @Override
    public void turnOff() {
        if (!this.isOn()) {
            notifyUser("la machine à café [" + label + "] est déjà en veille");
        } else {
            this.setOn(false);
            System.out.println("La machine à café [" + label + "] est en veille");
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
        this.turnOn();
        this.turnOff();
    }

    @Override
    public String report() {
        return "SmartCoffeeMachine " + label + "{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public void run() {
        this.schedule(10100);
        this.schedule(8000);
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
