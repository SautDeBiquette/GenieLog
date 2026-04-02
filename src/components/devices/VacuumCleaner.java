package components.devices;

import components.smartDevices.SmartVacuumCleaner;
import factories.DeviceFactory;
import interfaces.SmartDevice;

public class VacuumCleaner  extends DeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new SmartVacuumCleaner();
    }
}
