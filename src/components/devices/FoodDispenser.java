package components.devices;

import components.smartDevices.SmartFoodDispenser;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class FoodDispenser  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartFoodDispenser();
    }
}
