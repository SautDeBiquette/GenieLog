package components.devices;

import components.smartDevices.SmartDishwasher;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class Dishwasher  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartDishwasher();
    }
}
