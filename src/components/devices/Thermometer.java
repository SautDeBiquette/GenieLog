package components.devices;

import components.smartDevices.SmartThermometer;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class Thermometer  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartThermometer();
    }
}
