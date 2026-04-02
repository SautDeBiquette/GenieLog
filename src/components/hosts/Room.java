package components.hosts;

import interfaces.SmartDevice;

import java.util.List;

public class Room {
    private final List<SmartDevice> roomsDevices;
    private String roomName;

    public Room(List<SmartDevice> roomsDevices, String roomName) {
        this.roomsDevices = roomsDevices;
        this.roomName = roomName;
    }

    public void addSmartDevice(SmartDevice smartDevice) {
        this.roomsDevices.add(smartDevice);
        System.out.println("Smart device successfully added");
    }

    public void removeSmartDevice(SmartDevice smartDevice) {
        this.roomsDevices.remove(smartDevice);
        System.out.println("Smart device successfully removed");
    }

    public List<SmartDevice> getRoomsDevices() {
        return this.roomsDevices;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
