package factories;

import interfaces.SmartDevice;

import java.sql.Time;

public abstract class DeviceFactory {
    public abstract SmartDevice createSmartDevice();
}
