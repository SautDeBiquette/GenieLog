package components.devices;

import components.smartDevices.SmartCoffeeMachine;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class CoffeeMachine  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartCoffeeMachine();
    }
}
