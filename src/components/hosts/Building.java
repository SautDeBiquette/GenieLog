package components.hosts;

import java.util.Map;

public abstract class Building {

    private final Map<String, Room> rooms;
    private final String name;
    private final String location;

    public Building(Map<String, Room> rooms, String name, String location) {
        this.rooms = rooms;
        this.name = name;
        this.location = location;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

