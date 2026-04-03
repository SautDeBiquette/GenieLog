import builders.HomeBuilder;
import builders.HostDirector;
import builders.WorkplaceBuilder;
import components.devices.*;
import components.hosts.Home;
import components.hosts.Room;
import components.hosts.Workplace;
import components.smartDevices.*;
import factories.DeviceFactory;
import interfaces.SmartDevice;
import utils.POSITION;
import utils.Timer;
import utils.User;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================");
        System.out.println("   DÉMO SMART HOME & SMART WORKPLACE    ");
        System.out.println("========================================\n");

        // ─────────────────────────────────────────
        // 1. DÉMO FACTORY — Création de SmartDevices
        // ─────────────────────────────────────────
        System.out.println("Création des appareils via DeviceFactory\n");

        DeviceFactory blindsFactory = new Blinds();
        DeviceFactory thermometerFactory = new Thermometer();
        DeviceFactory coffeeMachineFactory = new CoffeeMachine();
        DeviceFactory dishwasherFactory = new Dishwasher();
        DeviceFactory doorFactory = new Door();
        DeviceFactory vacuumFactory = new VacuumCleaner();
        DeviceFactory washingFactory = new WashingMachine();
        DeviceFactory foodDispenserFactory = new FoodDispenser();

        SmartDevice blinds = blindsFactory.createSmartDevice();
        SmartDevice thermostat = thermometerFactory.createSmartDevice();
        SmartDevice coffee = coffeeMachineFactory.createSmartDevice();
        SmartDevice dishwasher = dishwasherFactory.createSmartDevice();
        SmartDevice door = doorFactory.createSmartDevice();
        SmartDevice vacuum = vacuumFactory.createSmartDevice();
        SmartDevice washing = washingFactory.createSmartDevice();
        SmartDevice foodDispenser = foodDispenserFactory.createSmartDevice();

        SmartDevice blinds2 = blindsFactory.createSmartDevice();
        SmartDevice thermostat2 = thermometerFactory.createSmartDevice();
        SmartDevice coffee2 = coffeeMachineFactory.createSmartDevice();
        SmartDevice dishwasher2 = dishwasherFactory.createSmartDevice();
        SmartDevice door2 = doorFactory.createSmartDevice();
        SmartDevice vacuum2 = vacuumFactory.createSmartDevice();
        SmartDevice washing2 = washingFactory.createSmartDevice();
        SmartDevice foodDispenser2 = foodDispenserFactory.createSmartDevice();


        ((SmartBlinds) blinds).setLabel("Volets salon");
        ((SmartBlinds) blinds).setSerialNumber("BL-001");
        ((SmartThermometer) thermostat).setLabel("Thermostat salon");
        ((SmartThermometer) thermostat).setSerialNumber("TH-9000");
        ((SmartThermometer) thermostat).setTemperature(11.8);
        ((SmartCoffeeMachine) coffee).setLabel("Cafew Carnaval (4x4 teinté)");
        ((SmartCoffeeMachine) coffee).setSerialNumber("CL4-P-TP");
        ((SmartDishwasher) dishwasher).setLabel("Lave-vaisselle cuisine");
        ((SmartDishwasher) dishwasher).setSerialNumber("DHWSHR-42069");
        ((SmartDoor) door).setLabel("La puerta");
        ((SmartDoor) door).setSerialNumber("PRT-879");
        ((SmartVacuumCleaner) vacuum).setLabel("daBigSuck");
        ((SmartVacuumCleaner) vacuum).setLabel("6767676767");
        ((SmartWashingMachine) washing).setLabel("Lavlavlav");
        ((SmartWashingMachine) washing).setSerialNumber("45-WM-666");
        ((SmartFoodDispenser) foodDispenser).setLabel("Gib food");
        ((SmartFoodDispenser) foodDispenser).setSerialNumber("C4TF00D");

        ((SmartBlinds) blinds2).setLabel("Volets Open Space");
        ((SmartBlinds) blinds2).setSerialNumber("BL-002");
        ((SmartThermometer) thermostat2).setLabel("Thermostat Open Space");
        ((SmartThermometer) thermostat2).setSerialNumber("TH-9999");
        ((SmartThermometer) thermostat2).setTemperature(8);
        ((SmartCoffeeMachine) coffee2).setLabel("Cafew Salle Café");
        ((SmartCoffeeMachine) coffee2).setSerialNumber("CL6-P-TP");
        ((SmartDishwasher) dishwasher2).setLabel("Lave-vaisselle local tech");
        ((SmartDishwasher) dishwasher2).setSerialNumber("DHWSHR-420848");
        ((SmartDoor) door2).setLabel("The CORPORATE door");
        ((SmartDoor) door2).setSerialNumber("PRT-6767");
        ((SmartVacuumCleaner) vacuum2).setLabel("B-MAX PRO");
        ((SmartVacuumCleaner) vacuum2).setLabel("6969696969");
        ((SmartWashingMachine) washing2).setLabel("lavPourPuant");
        ((SmartWashingMachine) washing2).setSerialNumber("420-WM-777");
        ((SmartFoodDispenser) foodDispenser2).setLabel("Tech food");
        ((SmartFoodDispenser) foodDispenser2).setSerialNumber("N00B");
        //

        System.out.println();

        System.out.println("Construction d'une Smart Home\n");

        Room salon = new Room(Map.of("blinds", blinds, "thermostat", thermostat, "vacuum", vacuum), "Salon");
        Room cuisine = new Room(Map.of("coffee", coffee, "dishwasher", dishwasher, "foodDispenser", foodDispenser), "Cuisine");
        Room entree = new Room(Map.of("door", door), "Entrée");

        HomeBuilder homeBuilder = new HomeBuilder();


        System.out.println("Construction d'un Smart Workplace\n");

        Room openSpace = new Room(Map.of("thermostat", thermostat2, "blinds", blinds2), "Open Space");
        Room salleCafe = new Room(Map.of("coffee", coffee2, "foodDispenser", foodDispenser2), "Salle café");
        Room local = new Room(Map.of("washing", washing2, "dishwasher", dishwasher2), "Local tech");

        WorkplaceBuilder workplaceBuilder = new WorkplaceBuilder();

        HostDirector director = new HostDirector(workplaceBuilder, homeBuilder);

        director.constructHome(
                "Villa Les Pins",
                "12 rue des Mimosas, Toulouse",
                Map.of(salon.getRoomName(), salon, cuisine.getRoomName(), cuisine, entree.getRoomName(), entree)
        );

        director.constructWorkplace(
                "TechCorp HQ",
                "42 avenue Compans-Caffarelli, Toulouse",
                Map.of(openSpace.getRoomName(), openSpace, salleCafe.getRoomName(), salleCafe, local.getRoomName(), local)
        );


        Home home = homeBuilder.getResult();
        System.out.println("Maison construite : " + home.getName()
                + " à " + home.getLocation());
        System.out.println("Pièces : " + home.getRooms().size() + "\n");

        Workplace workplace = workplaceBuilder.getResult();
        System.out.println("Lieu de travail construit : " + workplace.getName()
                + " à " + workplace.getLocation());
        System.out.println("Salles : " + workplace.getRooms().size() + "\n");

        //Definition d'un User :
        User user = new User("Sacha Dittersdorff", Map.of("home", home, "workplace", workplace));
        user.setPosition(POSITION.HOME);
        user.helloWorld();

        //Définition des différents Threads
        Thread blindsThread = new Thread(blinds);
        Thread thermostatThread = new Thread(thermostat);
        Thread coffeeThread = new Thread(coffee);
        Thread dishwasherThread = new Thread(dishwasher);
        Thread doorThread = new Thread(door);
        Thread vacuumThread = new Thread(vacuum);
        Thread washingThread = new Thread(washing);
        Thread foodDispenserThread = new Thread(foodDispenser);
        Thread userThread = new Thread(user);
        //Pour garder un oeil sur le temps qui passe
        Timer timer = new Timer();
        Thread timerThread = new Thread(timer);

        //Lancement des Threads
        timerThread.start();
        userThread.start();
        blindsThread.start();
        thermostatThread.start();
        coffeeThread.start();
        dishwasherThread.start();
        doorThread.start();
        vacuumThread.start();
        washingThread.start();
        foodDispenserThread.start();
    }
}

