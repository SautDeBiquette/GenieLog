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

    @Override
    public void run() {

    }
}
