package builders;

import components.hosts.Room;
import components.hosts.Workplace;
import interfaces.HostBuilder;

import java.util.Map;

public class WorkplaceBuilder implements HostBuilder {

    private Map<String, Room> rooms;
    private String name;
    private String location;

    @Override
    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    public Workplace getResult() {
        return new Workplace(rooms, name, location);
    }
}
