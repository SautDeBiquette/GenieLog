package builders;

import components.hosts.Room;
import components.hosts.Workplace;
import interfaces.HostBuilder;

import java.util.List;

public class WorkplaceBuilder implements HostBuilder {

    private List<Room> rooms;
    private String name;
    private String location;

    @Override
    public void setRooms(List<Room> rooms) {
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
