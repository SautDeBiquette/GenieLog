package components.devices;

import components.smartDevices.SmartBlinds;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class Blinds extends DeviceFactory {

    @Override
    public SmartDevice createSmartDevice() {
        return new SmartBlinds();
    }
}
