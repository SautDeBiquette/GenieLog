package components.hosts;

import java.util.Map;

public class Workplace extends Building {
    public Workplace(Map<String, Room> rooms, String name, String location) {
        super(rooms, name, location);
    }
}
