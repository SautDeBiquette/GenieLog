package builders;

import components.hosts.Room;

import java.util.Map;

public class HostDirector {

    private final WorkplaceBuilder workplaceBuilder;
    private final HomeBuilder homeBuilder;

    public HostDirector(WorkplaceBuilder workplaceBuilder, HomeBuilder homeBuilder) {
        this.workplaceBuilder = workplaceBuilder;
        this.homeBuilder = homeBuilder;
    }

    public void constructWorkplace(String name, String location, Map<String, Room> rooms) {
        workplaceBuilder.setName(name);
        workplaceBuilder.setLocation(location);
        workplaceBuilder.setRooms(rooms);
    }

    public void constructHome(String name, String location, Map<String, Room> rooms) {
        homeBuilder.setName(name);
        homeBuilder.setLocation(location);
        homeBuilder.setRooms(rooms);
    }
}