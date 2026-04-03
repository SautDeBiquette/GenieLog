package interfaces;

import components.hosts.Room;

import java.util.Map;

public interface HostBuilder {
    void setRooms(Map<String, Room> rooms);

    void setName(String name);

    void setLocation(String location);
}
