package components.hosts;

import interfaces.SmartDevice;

import java.util.List;

public class Home {
    private final List<Room> rooms;
    private final String name;
    private final String location;

    public Home(List<Room> rooms, String name, String location) {
        this.rooms = rooms;
        this.name = name;
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
