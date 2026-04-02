package components.devices;

import components.smartDevices.SmartDoor;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class Door  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartDoor();
    }
}
