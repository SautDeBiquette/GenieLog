package interfaces;

import components.hosts.Room;

import java.util.List;

public interface HostBuilder {
    void setRooms(List<Room> rooms);
    void setName(String name);
    void setLocation(String location);
}
