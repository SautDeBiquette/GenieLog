package components.hosts;

import interfaces.SmartDevice;

import java.util.Map;

public class Room {
    private final Map<String, SmartDevice> roomsDevices;
    private String roomName;

    public Room(Map<String, SmartDevice> roomsDevices, String roomName) {
        this.roomsDevices = roomsDevices;
        this.roomName = roomName;
    }

    public void addSmartDevice(String name, SmartDevice smartDevice) {
        this.roomsDevices.put(name, smartDevice);
        System.out.println("Smart device successfully added");
    }

    public void removeSmartDevice(String name) {
        this.roomsDevices.remove(name);
        System.out.println("Smart device successfully removed");
    }

    public Map<String, SmartDevice> getRoomsDevices() {
        return this.roomsDevices;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
