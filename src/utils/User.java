package utils;

import components.hosts.Building;

import java.util.Map;

public class User implements Runnable {
    private String name;
    private POSITION position;
    private Map<String, Building> buildingList;

    public User(String name, Map<String, Building> buildingList) {
        this.name = name;
        this.buildingList = buildingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public POSITION getPosition() {
        return position;
    }

    public void setPosition(POSITION position) {
        this.position = position;
    }

    public Map<String, Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(Map<String, Building> buildingList) {
        this.buildingList = buildingList;
    }

    public void helloWorld() {
        System.out.println("Bienvenue " + name + " dans notre environnement ! Vous êtes actuellement " + position);
        System.out.println("Voici vos propriétés :");
        this.getBuildingList().forEach((buildingKey, building) -> System.out.println("-" + building.getName())
        );
    }

    public void leaveAt(POSITION newPosition, int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " part de " + this.getPosition());
        Map<String, Building> buildings = this.getBuildingList();
        switch (newPosition) {
            case HOME -> {
                buildings.get("home").getRooms().get("Salon").getRoomsDevices().get("blinds").turnOff();
                buildings.get("home").getRooms().get("Cuisine").getRoomsDevices().get("coffee").turnOff();
            }
            case WORKPLACE -> {
                buildings.get("workplace").getRooms().get("Open Space").getRoomsDevices().get("blinds").turnOff();
                buildings.get("workplace").getRooms().get("Salle café").getRoomsDevices().get("coffee").turnOff();
            }
        }
        System.out.println("L'application à préparé le départ de " + this.getName());
        this.setPosition(newPosition);
    }

    public void leaveFor(POSITION newPosition, int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " part pour " + newPosition);
        Map<String, Building> buildings = this.getBuildingList();
        switch (newPosition) {
            case HOME -> {
                buildings.get("home").getRooms().get("Salon").getRoomsDevices().get("blinds").turnOn();
                buildings.get("home").getRooms().get("Cuisine").getRoomsDevices().get("coffee").turnOn();
                buildings.get("workplace").getRooms().get("Open Space").getRoomsDevices().get("blinds").turnOff();
                buildings.get("workplace").getRooms().get("Salle café").getRoomsDevices().get("coffee").turnOff();
            }
            case WORKPLACE -> {
                buildings.get("workplace").getRooms().get("Open Space").getRoomsDevices().get("blinds").turnOn();
                buildings.get("workplace").getRooms().get("Salle café").getRoomsDevices().get("coffee").turnOn();
                buildings.get("home").getRooms().get("Salon").getRoomsDevices().get("blinds").turnOff();
                buildings.get("home").getRooms().get("Cuisine").getRoomsDevices().get("coffee").turnOff();
            }
        }
        System.out.println("L'application à préparé l'arrivée de " + this.getName());
        this.setPosition(newPosition);
    }

    @Override
    public void run() {
        leaveAt(POSITION.HOME, 12000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Sacha est rentrée de chez la nounou et enclenche l'ouverture de ses volets elle-même");
        this.getBuildingList().get("home").getRooms().get("Salon").getRoomsDevices().get("blinds").turnOn();
        leaveFor(POSITION.WORKPLACE, 13000);
        leaveFor(POSITION.HOME, 6000);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Bonne nuit Sacha et Violette !!");

    }
}
