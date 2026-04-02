package components.smartDevices;

import interfaces.SmartDevice;

import java.sql.Time;

public class SmartCoffeeMachine implements SmartDevice, Runnable {
    private String serialNumber;
    private String label;
    private boolean isOn;

    @Override
    public void turnOn() {
        if(this.isOn()) {
            notifyUser("La machine à café [" + label + "] fait déjà un café ");
        } else {
            notifyUser("la machine à café [" + label + "] fait un café... ");
            this.setOn(true);
            try { Thread.sleep(3000);} catch (InterruptedException e) {Thread.currentThread().interrupt();}
            notifyUser("la machine à café [" + label + "] à fini de faire un café");
            this.setOn(false);
        }
    }

    @Override
    public void turnOff() {
        if(this.isOn()) {
            this.setOn(false);
            try { Thread.sleep(3000);} catch (InterruptedException e) {Thread.currentThread().interrupt();}
            System.out.println("La machine à café [" + label + "] arrête de faire un café ");
        } else {
            System.out.println("La machine à café [" + label + "] ne fait pas de café actuellement ");
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
        return "SmartCoffeeMachine "+ label +"{" +
                "serialNumber='" + serialNumber + '\'' +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public void run(){}

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
